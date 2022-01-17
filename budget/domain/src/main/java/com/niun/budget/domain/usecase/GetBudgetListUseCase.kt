package com.niun.budget.domain.usecase

import com.niun.budget.domain.model.Budget
import kotlinx.coroutines.flow.Flow

interface GetBudgetListUseCase {
    fun budgetList(): Flow<List<Budget>>
}