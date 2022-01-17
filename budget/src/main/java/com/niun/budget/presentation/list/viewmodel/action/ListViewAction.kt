package com.niun.budget.presentation.list.viewmodel.action

import com.niun.core.state.ViewAction

internal sealed class ListViewAction : ViewAction {

    data class ViewDetails(val id: String) : ListViewAction()
}