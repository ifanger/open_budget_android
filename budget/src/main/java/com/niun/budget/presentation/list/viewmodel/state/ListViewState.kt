package com.niun.budget.presentation.list.viewmodel.state

import com.niun.budget.domain.model.Budget
import com.niun.core.state.ViewState

internal sealed class ListViewState : ViewState {
    object Loading : ListViewState()
    object Error : ListViewState()

    data class Success(val budgets: List<Budget>) : ListViewState()
}