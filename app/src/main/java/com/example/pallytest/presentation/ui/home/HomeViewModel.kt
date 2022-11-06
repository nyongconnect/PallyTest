package com.example.pallytest.presentation.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pallytest.model.EventModel
import com.example.pallytest.model.MilongasModel
import com.example.pallytest.model.TeachersModel
import com.example.pallytest.presentation.utils.DummyHelper
import com.example.pallytest.presentation.utils.DummyHelper.dummyEvent
import com.example.pallytest.presentation.utils.DummyHelper.dummyMilangas
import com.example.pallytest.presentation.utils.DummyHelper.dummyTeacher
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

) : ViewModel() {

    val state: MutableLiveData<ViewState> = MutableLiveData()

    init {
        state.postValue(ViewState())
    }

    data class ViewState(
        val events: MutableList<EventModel> = mutableListOf(dummyEvent, dummyEvent, dummyEvent),
        val teachers: MutableList<TeachersModel> = mutableListOf(dummyTeacher, dummyTeacher, dummyTeacher),
        val milongas: MutableList<MilongasModel> = mutableListOf(dummyMilangas, dummyMilangas, dummyMilangas),
        val hasData: Boolean = true
    )
}