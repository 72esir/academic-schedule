package com.example.academicschedule

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.academicschedule.databinding.DaysListItemBinding
import com.example.academicschedule.models.DailySchedule

class DaysAdapter(private val days : List<DailySchedule>) :
    RecyclerView.Adapter<DaysAdapter.DayViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DayViewHolder {
        val context = parent.context
        val layoutInflater = LayoutInflater.from(context)
        val binding = DaysListItemBinding.inflate(
            layoutInflater,
            parent,
            false
        )

        return DayViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: DayViewHolder,
        position: Int
    ) {
        val day = days[position]
        val lessonsAdapter = LessonsAdapter(day.lessonsList)

        val myLayoutManager = LinearLayoutManager(
            holder.itemView.context,
            LinearLayoutManager.VERTICAL,
            false
        )

        holder.binding.listOfLessons.apply {
            adapter = lessonsAdapter
            setHasFixedSize(true)
            layoutManager = myLayoutManager
        }
        holder.bind(day)
    }

    override fun getItemCount() = days.size

    class DayViewHolder(val binding: DaysListItemBinding) :
        RecyclerView.ViewHolder(binding.root){

        fun bind(day: DailySchedule){
            binding.dayOfWeek.text = day.title
            binding.date.text = day.date
        }
    }
}