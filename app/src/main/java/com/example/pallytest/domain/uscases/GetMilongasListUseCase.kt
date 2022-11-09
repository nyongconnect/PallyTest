package com.example.pallytest.domain.uscases

import com.example.pallytest.domain.repository.PallyRepository
import com.example.pallytest.model.GetMilongasRequest
import com.example.pallytest.model.Milongas
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMilongasListUseCase @Inject constructor(
    private val pallyRepository: PallyRepository
): FlowUseCase<MutableList<Milongas>, GetMilongasRequest>() {

    override suspend fun buildFlowUseCase(params: GetMilongasRequest?): Flow<MutableList<Milongas>> {
        return pallyRepository.getMilongas(params?: GetMilongasRequest())
    }
}