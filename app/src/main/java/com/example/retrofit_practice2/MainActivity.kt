package com.example.retrofit_practice2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.retrofit_practice2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: LectureListViewModel
    private val adapter = LecturesRecyclerviewAdapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository = LectureGetRepository()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lecturesRecycler.adapter = adapter
        viewModel = ViewModelProvider(this, LectureListViewModelFactory(repository))[LectureListViewModel::class.java]
        viewModel.lectureList.observe(this,{
            adapter.setData(it)
        })
        viewModel.page.observe(this,{
            binding.pageText.text = it.toString()
            if(it == 1){
                binding.prevButton.visibility = INVISIBLE
            } else binding.prevButton.visibility = VISIBLE
        })
        binding.prevButton.setOnClickListener {
            viewModel.decreasePage()
        }
        binding.nextButton.setOnClickListener {
            viewModel.increasePage()
        }
        adapter.setOnItemClickListenser(object : LecturesRecyclerviewAdapter.OnitemClickListener{
            override fun onItemClick(view: View, data: Lecture, position: Int) {
                goLectureInfoActivity(data)
            }
        })
    }
    fun goLectureInfoActivity(data : Lecture){
        val intent = Intent(this, LectureInfoActivity::class.java)
        intent.putExtra("id", data.id)
        startActivity(intent)
    }
}