package com.example.pallytest.remote.api

import com.example.pallytest.model.*
import retrofit2.http.Body
import retrofit2.http.POST

interface PallyApi {

    @POST("GetMillongsList")
    suspend fun getMillongsList( @Body getMilongasRequest: GetMilongasRequest): MilongasResponse

    @POST("GetEvents")
    suspend fun getEvents( @Body getEventsRequest: GetEventsRequest ): EventsResponse

    @POST("GetTeacherList")
    suspend fun getTeachers( @Body getTeachersRequest: GetTeachersRequest ): TeachersResponse

    @POST("loginUser")
    suspend fun login( @Body loginRequest: LoginRequest ): LoginResponse
}