package com.niun.budget.domain.repository

import com.niun.budget.domain.model.Budget
import kotlinx.coroutines.flow.Flow

interface BudgetRepository {
    fun getList(): Flow<List<Budget>>
    fun getDetails(id: String): Flow<Budget>
    fun save(budget: Budget)
    fun delete(id: String)
}