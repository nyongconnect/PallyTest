package com.example.pallytest.model

data class GetEventsRequest(
    val lati: Double = 30.40,
    val longi: Double = 65.80,
    val offset: String = "0"
)