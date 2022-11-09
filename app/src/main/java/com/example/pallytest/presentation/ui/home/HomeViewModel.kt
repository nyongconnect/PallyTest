package com.example.pallytest.presentation.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pallytest.domain.uscases.GetDashboardItemUseCase
import com.example.pallytest.domain.uscases.GetEventsUseCase
import com.example.pallytest.domain.uscases.GetMilongasListUseCase
import com.example.pallytest.domain.uscases.GetTeachersUseCase
import com.example.pallytest.model.*
import com.example.pallytest.presentation.utils.DummyHelper.dummyEvent
import com.example.pallytest.presentation.utils.DummyHelper.dummyMilangas
import com.example.pallytest.presentation.utils.DummyHelper.dummyTeacher
import com.example.pallytest.presentation.utils.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getDashboardItemUseCase: GetDashboardItemUseCase
) : ViewModel() {

    private val _state: MutableLiveData<ViewState> = MutableLiveData()
    val state: LiveData<ViewState> = _state.asLiveData()


    init {
        getDashboardItems()
    }

    private fun getDashboardItems() {
        viewModelScope.launch {
            getDashboardItemUseCase.execute().onStart {

            }.catch {

            }.collect {
                _state.postValue(ViewState(
                    it.events,
                    it.teachers,
                    it.milongas,
                    hasData = true
                ))
            }
        }
    }

    data class ViewState(
        val events: MutableList<Event> = mutableListOf(),
        val teachers: MutableList<Teacher> = mutableListOf(),
        val milongas: MutableList<Milongas> = mutableListOf(),
        val hasData: Boolean = true
    )
}