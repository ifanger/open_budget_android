package com.niun.budget.presentation.list.viewmodel

import androidx.lifecycle.viewModelScope
import com.niun.budget.domain.usecase.GetBudgetListUseCase
import com.niun.budget.presentation.list.viewmodel.action.ListViewAction
import com.niun.budget.presentation.list.viewmodel.event.ListViewEvent
import com.niun.budget.presentation.list.viewmodel.state.ListViewState
import com.niun.core.base.BaseViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

internal class ListViewModel(
    private val getBudgetListUseCase: GetBudgetListUseCase
) : BaseViewModel<ListViewState, ListViewEvent, ListViewAction>() {

    override fun getInitialState() = ListViewState.Loading

    override fun sendAction(action: ListViewAction) {
        when (action) {
            is ListViewAction.ViewDetails -> sendEvent(ListViewEvent.OpenDetails(action.id))
        }
    }

    fun loadBudgets() = viewModelScope.launch {
        getBudgetListUseCase.budgetList()
            .onStart { updateState(ListViewState.Loading) }
            .collect {
                updateState(ListViewState.Success(it))
            }
    }
}