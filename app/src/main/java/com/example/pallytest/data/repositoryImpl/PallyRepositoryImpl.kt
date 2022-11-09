package com.example.pallytest.data.repositoryImpl

import com.example.pallytest.data.source.RemoteDataSource
import com.example.pallytest.domain.repository.PallyRepository
import com.example.pallytest.model.*
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PallyRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
): PallyRepository {

    override suspend fun getEvents(getEventsRequest: GetEventsRequest): Flow<MutableList<Event>> {
        return  remoteDataSource.getEvents(getEventsRequest)
    }

    override suspend fun getTeachers(getTeachersRequest: GetTeachersRequest): Flow<MutableList<Teacher>> {
        return remoteDataSource.getTeachers(getTeachersRequest)
    }

    override suspend fun getMilongas(getMilongasRequest: GetMilongasRequest): Flow<MutableList<Milongas>> {
        return remoteDataSource.getMilongas(getMilongasRequest)
    }
}