package com.example.pallytest.presentation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pallytest.domain.uscases.GetDashboardItemUseCase
import com.example.pallytest.model.Event
import com.example.pallytest.model.Milongas
import com.example.pallytest.model.Teacher
import com.example.pallytest.presentation.utils.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
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