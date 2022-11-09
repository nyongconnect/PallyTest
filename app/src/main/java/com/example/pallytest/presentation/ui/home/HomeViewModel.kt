package com.example.pallytest.presentation.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pallytest.domain.uscases.GetEventsUseCase
import com.example.pallytest.domain.uscases.GetMilongasListUseCase
import com.example.pallytest.domain.uscases.GetTeachersUseCase
import com.example.pallytest.model.EventModel
import com.example.pallytest.model.GetEventsRequest
import com.example.pallytest.model.MilongasModel
import com.example.pallytest.model.TeachersModel
import com.example.pallytest.presentation.utils.DummyHelper.dummyEvent
import com.example.pallytest.presentation.utils.DummyHelper.dummyMilangas
import com.example.pallytest.presentation.utils.DummyHelper.dummyTeacher
import com.example.pallytest.presentation.utils.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getEventsUseCase: GetEventsUseCase,
    private val getMilongasListUseCase: GetMilongasListUseCase,
    private val getTeachersUseCase: GetTeachersUseCase
) : ViewModel() {

    private val _state: MutableLiveData<ViewState> = MutableLiveData()
    val state: LiveData<ViewState> = _state.asLiveData()


    init {
        _state.postValue(ViewState())
        getEvents()
    }

    fun getEvents() {
        viewModelScope.launch {
            getEventsUseCase.execute(GetEventsRequest()).onStart {
                Log.e("info", "getEvents:  starrted" )
            }.catch {
                Log.e("info", "getEvents:  error encountered" )
            }.collect {
                Log.e("info", "getEvents:  success," )
            }
        }
    }

    data class ViewState(
        val events: MutableList<EventModel> = mutableListOf(dummyEvent, dummyEvent, dummyEvent),
        val teachers: MutableList<TeachersModel> = mutableListOf(dummyTeacher, dummyTeacher, dummyTeacher),
        val milongas: MutableList<MilongasModel> = mutableListOf(dummyMilangas, dummyMilangas, dummyMilangas),
        val hasData: Boolean = true
    )
}