package com.example.pallytest.model

data class DashboardItem(
    val events: MutableList<Event> = mutableListOf(),
    val teachers: MutableList<Teacher> = mutableListOf(),
    val milongas: MutableList<Milongas>,
)