package com.example.pallytest.domain.uscases

import com.example.pallytest.domain.repository.PallyRepository
import com.example.pallytest.model.Event
import com.example.pallytest.model.GetEventsRequest
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetEventsUseCase @Inject constructor(
    private val pallyRepository: PallyRepository
): FlowUseCase<MutableList<Event>, GetEventsRequest>() {

    override suspend fun buildFlowUseCase(params: GetEventsRequest?): Flow<MutableList<Event>> {
        return pallyRepository.getEvents(params?: GetEventsRequest())
    }
}