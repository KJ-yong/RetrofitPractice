package com.example.retrofit_practice2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit_practice2.databinding.LecturesRecyclerviewBinding

class LecturesRecyclerviewAdapter(private val context: Context) :
    RecyclerView.Adapter<LecturesRecyclerviewAdapter.ViewHolder>() {
    private var datas = ArrayList<Lecture>()
    private var listener: OnitemClickListener? = null

    interface OnitemClickListener {
        fun onItemClick(view: View, data: Lecture, position: Int)
    }
    fun setOnItemClickListenser(listener: OnitemClickListener){
        this.listener = listener
    }

    inner class ViewHolder(val binding: LecturesRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Lecture) {
            val position = adapterPosition
            binding.lectureNameText.text = item.name
            binding.classificationText.text = item.classification
            binding.professorText.text = item.professor
            binding.totalRatingText.text = item.totalRating.toString()
            if(position!= RecyclerView.NO_POSITION){
                itemView.setOnClickListener{
                    listener?.onItemClick(itemView, item, position)
                }
            }
        }
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            LecturesRecyclerviewBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    fun setData(dataList: ArrayList<Lecture>) {
        datas = dataList
        notifyDataSetChanged()
    }
}