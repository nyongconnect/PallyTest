package com.example.pallytest.model

data class LoginRequest(
    val app_version: String = "decoderstudent@yopmail.com",
    val device_token: String = "123456",
    val device_type: String = "device_type",
    val email: String = "device_token",
    val password: String = "app_version",
    val time_zone: String = "Asia/Kolkota"
)