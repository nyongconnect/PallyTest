package com.example.pallytest.remote.service

import com.example.pallytest.data.source.RemoteDataSource
import com.example.pallytest.model.*
import com.example.pallytest.remote.api.PallyApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ApiService @Inject constructor(
    private val pallyApi: PallyApi
) : RemoteDataSource {

    override suspend fun getEvents(getEventsRequest: GetEventsRequest): Flow<MutableList<Event>> {
        return flow {
            val response = pallyApi.getEvents(getEventsRequest)
            emit(response.Event_List)
        }
    }

    override suspend fun getTeachers(getTeachersRequest: GetTeachersRequest): Flow<MutableList<Teacher>> {
        return flow {
            val response = pallyApi.getTeachers(getTeachersRequest)
            emit(response.teacher_list)
        }
    }

    override suspend fun getMilongas(getMilongasRequest: GetMilongasRequest): Flow<MutableList<Milongas>> {
        return flow {
            val response = pallyApi.getMillongsList(getMilongasRequest)
            emit(response.milongas_list)
        }
    }

}