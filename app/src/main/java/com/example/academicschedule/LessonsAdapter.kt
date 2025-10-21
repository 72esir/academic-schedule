package com.example.academicschedule

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.academicschedule.databinding.LessonsListItemBinding
import com.example.academicschedule.models.Lesson

class LessonsAdapter (private val lessons: List<Lesson>) :
    RecyclerView.Adapter<LessonsAdapter.LessonViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LessonViewHolder {
        val context = parent.context
        val layoutInflater = LayoutInflater.from(context)
        val binding = LessonsListItemBinding.inflate(
            layoutInflater,
            parent,
            false
        )
        return LessonViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: LessonViewHolder,
        position: Int
    ) {
        val lesson = lessons[position]
        holder.bind(lesson)
    }

    override fun getItemCount(): Int {
        println("DEBUG: Lessons count = ${lessons.size}")
        return lessons.size
    }

    class LessonViewHolder(val binding: LessonsListItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(lesson: Lesson){
            binding.lessonTitle.text = lesson.title
            binding.lessonLecturer.text = lesson.lecturer
            binding.lessonCabinet.text = lesson.cabinet
            binding.lessonStartTime.text = lesson.timeToStart
        }
    }
}