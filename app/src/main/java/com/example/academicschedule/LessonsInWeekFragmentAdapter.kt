package com.example.academicschedule

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.academicschedule.databinding.LessonsListForWeeklyScheduleItemBinding
import com.example.academicschedule.models.Lesson

class LessonsInWeekFragmentAdapter (private val lessons: List<Lesson>) :
    RecyclerView.Adapter<LessonsInWeekFragmentAdapter.WeekLessonViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WeekLessonViewHolder {
        val context = parent.context
        val layoutInflater = LayoutInflater.from(context)
        val binding = LessonsListForWeeklyScheduleItemBinding.inflate(
            layoutInflater,
            parent,
            false
        )
        return WeekLessonViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: WeekLessonViewHolder,
        position: Int
    ) {
        val lesson = lessons[position]
        holder.bind(lesson)
    }

    override fun getItemCount(): Int {
        return lessons.size
    }

    class WeekLessonViewHolder(val binding: LessonsListForWeeklyScheduleItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(lesson: Lesson){
            binding.lessonTitle.text = lesson.title
            binding.lessonStartTime.text = lesson.timeToStart
        }
    }
}