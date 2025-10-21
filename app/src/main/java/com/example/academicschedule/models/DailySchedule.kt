package com.example.academicschedule.models

data class DailySchedule(
    val title: String,
    val date: String,
    val lessonsList: List<Lesson>
)
