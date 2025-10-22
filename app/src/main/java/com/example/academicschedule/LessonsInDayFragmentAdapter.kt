package com.example.academicschedule

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.academicschedule.databinding.LessonsListForDailyScheduleItemBinding
import com.example.academicschedule.models.Lesson

class LessonsInDayFragmentAdapter (private val lessons: List<Lesson>) :
    RecyclerView.Adapter<LessonsInDayFragmentAdapter.DayLessonViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DayLessonViewHolder {
        val context = parent.context
        val layoutInflater = LayoutInflater.from(context)
        val binding = LessonsListForDailyScheduleItemBinding.inflate(
            layoutInflater,
            parent,
            false
        )
        return DayLessonViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: DayLessonViewHolder,
        position: Int
    ) {
        val lesson = lessons[position]
        holder.bind(lesson)
    }

    override fun getItemCount(): Int {
        return lessons.size
    }

    class DayLessonViewHolder(val binding: LessonsListForDailyScheduleItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(lesson: Lesson){
            binding.lessonTitle.text = lesson.title
            binding.lessonStartTime.text = lesson.timeToStart
        }
    }
}