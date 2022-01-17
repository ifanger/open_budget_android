package com.niun.budget.domain.usecase

import com.niun.budget.domain.model.Budget
import kotlinx.coroutines.flow.Flow

interface GetBudgetListUseCase {
    operator fun invoke(): Flow<List<Budget>>
}