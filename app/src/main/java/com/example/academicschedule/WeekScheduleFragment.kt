package com.example.academicschedule

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.academicschedule.databinding.FragmentWeekScheduleBinding
import com.example.academicschedule.models.DailySchedule
import com.example.academicschedule.models.Lesson
import com.example.academicschedule.models.WeeklySchedule
import dev.androidbroadcast.vbpd.viewBinding

class WeekScheduleFragment: Fragment(R.layout.fragment_week_schedule) {
    private val binding : FragmentWeekScheduleBinding by viewBinding(FragmentWeekScheduleBinding::bind)
    private var adapter: DaysAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lessonsMonEven = listOf(
            Lesson("Математика", "09:00", "Victor", "221"),
            Lesson("Химия", "10:30", "Ivan", "112")
        )

        val lessonsMonOdd = listOf(
            Lesson("Физика", "09:00", "Dmitro", "423"),
            Lesson("Химия", "10:30", "Ivan", "112")
        )
        val lessonsTueOdd = listOf(
            Lesson("Физика", "09:00", "Dmitro", "423"),
            Lesson("Химия", "10:30", "Ivan", "112")
        )
        val lessonsWedOdd = listOf(
            Lesson("Физика", "09:00", "Dmitro", "423"),
            Lesson("Химия", "10:30", "Ivan", "112")
        )


        val weekSchedule = WeeklySchedule(
            evenWeek = listOf(
                DailySchedule("Понедельник", "21 октября", lessonsMonEven),
                DailySchedule("Вторник", "22 октября", emptyList())
            ),
            oddWeek = listOf(
                DailySchedule("Понедельник", "21 октября", lessonsMonOdd),
                DailySchedule("Вторник", "22 октября", lessonsTueOdd),
                DailySchedule("Среда", "23 октября", lessonsWedOdd)
            )
        )

        val currentParity = "odd"
        val daysToShow = when (currentParity) {
            "even" -> weekSchedule.evenWeek
            "odd" -> weekSchedule.oddWeek
            else -> {weekSchedule.evenWeek}
        }

        binding.weekSchedule.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = DaysAdapter(daysToShow)
            setHasFixedSize(true)
        }
    }

    override fun onDestroyView() {
    super.onDestroyView()
        adapter = null
    }
}