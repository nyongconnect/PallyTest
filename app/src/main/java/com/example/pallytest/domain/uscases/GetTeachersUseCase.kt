package com.example.pallytest.domain.uscases

import com.example.pallytest.domain.repository.PallyRepository
import com.example.pallytest.model.GetTeachersRequest
import com.example.pallytest.model.Teacher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTeachersUseCase  @Inject constructor(
    private val pallyRepository: PallyRepository
): FlowUseCase<MutableList<Teacher>, GetTeachersRequest>() {

    override suspend fun buildFlowUseCase(params: GetTeachersRequest?): Flow<MutableList<Teacher>> {
        return pallyRepository.getTeachers(params?: GetTeachersRequest())
    }
}