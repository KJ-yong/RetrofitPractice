package com.example.retrofit_practice2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.retrofit_practice2.databinding.ActivityLectureInfoBinding

class LectureInfoActivity : AppCompatActivity() {
    lateinit var binding : ActivityLectureInfoBinding
    lateinit var viewModel : LectureInfoViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository = LectureGetRepository()
        val id = intent.getIntExtra("id",-1)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_lecture_info)
        viewModel = ViewModelProvider(this, LectureInfoViewModelFactory(id, repository))[LectureInfoViewModel::class.java]
        viewModel.lectureInfo.observe(this, {
            binding.lectureNameText.text = it.name
            binding.lectureCodeText.text = it.code
            binding.lectureClassificationText.text = it.classification
            binding.lectureProfessorText.text = "교수 : "+it.professor
            binding.lectureGradeText.text = "학점 : "+it.grade
            binding.lectureRatingText.text = "평점 : "+it.totalRating
        })
    }
}