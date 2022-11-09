package com.example.pallytest.data.source

import com.example.pallytest.model.*
import com.example.pallytest.remote.service.DashboardItem
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

    suspend fun getEvents(getEventsRequest: GetEventsRequest): Flow<MutableList<Event>>

    suspend fun getTeachers(getTeachersRequest: GetTeachersRequest): Flow<MutableList<Teacher>>

    suspend fun getMilongas(getMilongasRequest: GetMilongasRequest): Flow<MutableList<Milongas>>

    suspend fun getDashBoardItems(): Flow<DashboardItem>
}
