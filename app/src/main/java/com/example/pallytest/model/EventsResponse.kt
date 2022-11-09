package com.example.pallytest.model

data class EventsResponse(
    val Event_List: List<Event>,
    val message: String,
    val offset: Int,
    val status: Boolean,
    val user_access: Int
)

data class Event(
    val address: String,
    val created_at: String,
    val distance: Double,
    val event_details: String,
    val event_end_date: String,
    val event_link: String,
    val event_name: String,
    val event_start_date: String,
    val id: Int,
    val images: List<Image>,
    val lati: String,
    val longi: String,
    val status: String,
    val updated_at: String
)

data class Image(
    val created_at: String,
    val id: Int,
    val imageUrl: String,
    val status: String,
    val type: String,
    val updated_at: String,
    val userId: String
)