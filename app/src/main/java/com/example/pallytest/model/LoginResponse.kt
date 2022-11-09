package com.example.pallytest.model

data class LoginResponse(
    val message: String,
    val status: Boolean,
    val user_access: Int,
    val user_data: UserData
)

data class UserData(
    val accessToken: String,
    val address: String,
    val city: String,
    val country: String,
    val country_code: String,
    val created_at: String,
    val dob: Any? = null,
    val email: String,
    val first_name: String,
    val last_name: String,
    val lati: String,
    val loginToken: String,
    val longi: String,
    val otp: String,
    val phone_number: String,
    val rating: Int,
    val social_type: String,
    val updated_at: String,
    val user_access: Int,
    val user_id: Int,
    val user_image: String,
    val user_type: String
)