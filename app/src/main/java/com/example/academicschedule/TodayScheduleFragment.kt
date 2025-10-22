package com.example.academicschedule

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.academicschedule.databinding.FragmentTodayScheduleBinding
import com.example.academicschedule.models.Lesson
import dev.androidbroadcast.vbpd.viewBinding

class TodayScheduleFragment: Fragment(R.layout.fragment_today_schedule) {
    private val binding : FragmentTodayScheduleBinding by viewBinding (FragmentTodayScheduleBinding::bind)
    private var adapter: LessonsInDayFragmentAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lessonsMon = listOf(
            Lesson("Физика", "09:00", "Dmitro", "423"),
            Lesson("Химия", "10:30", "Ivan", "112")
        )

        binding.daySchedule.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = LessonsInDayFragmentAdapter(lessonsMon)
            setHasFixedSize(true)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        adapter = null
    }
}