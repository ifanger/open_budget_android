package com.niun.budget.domain.usecase

import com.niun.budget.domain.model.Budget
import com.niun.budget.domain.repository.BudgetRepository
import kotlinx.coroutines.flow.Flow

class GetBudgetListUseCaseImpl(
    private val budgetRepository: BudgetRepository
) : GetBudgetListUseCase {

    override operator fun invoke(): Flow<List<Budget>> = budgetRepository.getList()
}