package com.example.pallytest.domain.uscases

import com.example.pallytest.domain.repository.PallyRepository
import com.example.pallytest.model.DashboardItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDashboardItemUseCase  @Inject constructor(
    private val pallyRepository: PallyRepository
): FlowUseCase<DashboardItem, Unit>() {
    override suspend fun buildFlowUseCase(params: Unit?): Flow<DashboardItem> {
        return pallyRepository.getDashBoardItems()
    }
}