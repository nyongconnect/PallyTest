package com.example.pallytest.remote.service

import com.example.pallytest.data.source.RemoteDataSource
import com.example.pallytest.model.*
import com.example.pallytest.remote.api.PallyApi
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
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

    override suspend fun getDashBoardItems(): Flow<DashboardItem> {
        return flow {
            coroutineScope {
                val getEvent = async {  pallyApi.getEvents(GetEventsRequest())  }
                val getMilongas = async {   pallyApi.getMillongsList(GetMilongasRequest())  }
                val getTeachers = async {   pallyApi.getTeachers(GetTeachersRequest())  }

                emit(DashboardItem(
                    getEvent.await().Event_List,
                    getTeachers.await().teacher_list,
                    getMilongas.await().milongas_list))
            }
        }
    }

}

data class DashboardItem(
    val events: MutableList<Event> = mutableListOf(),
    val teachers: MutableList<Teacher> = mutableListOf(),
    val milongas: MutableList<Milongas>,
)