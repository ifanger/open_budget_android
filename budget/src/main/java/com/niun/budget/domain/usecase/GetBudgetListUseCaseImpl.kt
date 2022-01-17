package com.niun.budget.domain.usecase

import com.niun.budget.domain.model.Budget
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.Date

class GetBudgetListUseCaseImpl : GetBudgetListUseCase {

    override fun budgetList(): Flow<List<Budget>> = flow {
        kotlinx.coroutines.delay(4500)
        emit(
            listOf(
                Budget(
                    "id",
                    "title",
                    Date(),
                    "Raul",
                    emptyList()
                )
            )
        )
        println("emiti o role hein")
    }
}