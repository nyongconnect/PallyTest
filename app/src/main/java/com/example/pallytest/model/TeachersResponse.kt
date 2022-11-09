package com.example.pallytest.model

data class TeachersResponse(
    val message: String,
    val offset: Int,
    val status: Boolean,
    val teacher_count: Int,
    val teacher_list: List<Teacher>,
    val user_access: Int
)

data class Teacher(
    val admin_commission: Int,
    val availability_id: String,
    val city: String,
    val country: String,
    val country_code: String,
    val created_At: String,
    val date: String,
    val day: String,
    val description: String,
    val distance: String,
    val inperson_fees: String,
    val is_favourite: Int,
    val language_speak: String,
    val level: Int,
    val online_fees: String,
    val primary_role: String,
    val reviews_total_count: Int,
    val school_id: Int,
    val slot: String,
    val slot_type: String,
    val teacher_id: Int,
    val teacher_image: String?,
    val teacher_name: String,
    val teacher_rating: Double,
    val verification: Int,
    val year_of_experience: Int
)