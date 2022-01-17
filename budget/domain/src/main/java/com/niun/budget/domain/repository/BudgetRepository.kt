package com.niun.budget.domain.repository

import com.niun.budget.domain.model.Budget
import kotlinx.coroutines.flow.Flow

interface BudgetRepository {
    fun getList(): Flow<List<Budget>>
    fun getDetails(id: String): Flow<Budget>
    suspend fun save(budget: Budget)
    suspend fun delete(id: String)
}