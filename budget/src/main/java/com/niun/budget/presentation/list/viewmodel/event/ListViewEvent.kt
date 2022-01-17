package com.niun.budget.presentation.list.viewmodel.event

import com.niun.core.state.ViewEvent

internal sealed class ListViewEvent : ViewEvent {

    data class OpenDetails(val id: String) : ListViewEvent()

    object ShowError : ListViewEvent()
}