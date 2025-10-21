package com.example.academicschedule.models

data class WeeklySchedule(
    val evenWeek: List<DailySchedule>,
    val oddWeek: List<DailySchedule>
)