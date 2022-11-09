package com.example.pallytest.domain.repository

import com.example.pallytest.model.*
import kotlinx.coroutines.flow.Flow

interface PallyRepository {

    suspend fun getEvents(getEventsRequest: GetEventsRequest): Flow<MutableList<Event>>

    suspend fun getTeachers(getTeachersRequest: GetTeachersRequest): Flow<MutableList<Teacher>>

    suspend fun getMilongas(getMilongasRequest: GetMilongasRequest): Flow<MutableList<Milongas>>
}