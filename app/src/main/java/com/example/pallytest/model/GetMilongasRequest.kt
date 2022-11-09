package com.example.pallytest.model

data class GetMilongasRequest(
    val day: String = "",
    val lati: Double = 30.40,
    val longi: Double = 65.80,
    val milonga_name: String = "",
    val offset: String = "0",
    val radius: Int = 0,
    val rating_atleast: Int = 90000,
    val sortBy: String = ""
)