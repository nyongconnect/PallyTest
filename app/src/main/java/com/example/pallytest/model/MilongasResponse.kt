package com.example.pallytest.model

data class MilongasResponse(
    val message: String,
    val milongas_list: MutableList<Milongas>,
    val offset: Int,
    val status: Boolean,
    val user_access: Int
)

data class Milongas(
    val address: Any,
    val city: String,
    val country: String,
    val country_code: String,
    val dob: String,
    val email: String,
    val first_name: String,
    val last_name: String,
    val lati: String,
    val longi: String,
    val milonga_detail: MilongaDetail,
    val phone_number: Any?,
    val rating: Int,
    val reviews_count_avg_star: Any?,
    val reviews_count_count: Int,
    val user_id: Int,
    val user_image: String
)

data class MilongaDetail(
    val distance: String,
    val email: String,
    val facebook_link: String,
    val instagram_link: String,
    val is_favourite: Int,
    val is_review: Int,
    val lati: String,
    val longi: String,
    val milonga_address: String,
    val milonga_close_time: String,
    val milonga_days: List<MilongaDay>,
    val milonga_description: String,
    val milonga_id: Int,
    val milonga_images: List<MilongaImage>,
    val milonga_lesson_end: String,
    val milonga_lesson_start: String,
    val milonga_name: String,
    val milonga_opening_time: String,
    val milongas_rating: Int,
    val phone_number: String,
    val profileImage: String,
    val reviews_total_count: Int,
    val status: String,
    val twitter_link: String,
    val whatsapp_number: String
)

data class MilongaDay(
    val created_at: String,
    val id: Int,
    val milonga_day: String,
    val updated_at: String,
    val user_id: String
)

data class MilongaImage(
    val created_at: String,
    val id: Int,
    val imageUrl: String,
    val status: String,
    val type: String,
    val updated_at: String,
    val userId: String
)