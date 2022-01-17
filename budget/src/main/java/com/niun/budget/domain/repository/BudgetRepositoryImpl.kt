package com.niun.budget.domain.repository

import com.niun.budget.database.BudgetDatabase
import com.niun.budget.database.dao.BudgetDao
import com.niun.budget.database.entity.BudgetEntity
import com.niun.budget.domain.model.Budget
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.transform
import java.util.Date

internal class BudgetRepositoryImpl(budgetDatabase: BudgetDatabase) : BudgetRepository {

    private val budgetDao: BudgetDao by dao(budgetDatabase)

    override fun getList(): Flow<List<Budget>> = flow {
        emit(budgetDao.getAll())
    }.transform { entities ->
        entities.map { entity ->
            entity.asBudget()
        }
    }

    override fun getDetails(id: String): Flow<Budget> = flow {
        emit(budgetDao.getById(id.toInt()))
    }.transform { entity -> entity.asBudget() }

    override suspend fun save(budget: Budget) {
        return budgetDao.save(budget.asEntity())
    }

    override suspend fun delete(id: String) {
        return budgetDao.delete(id.toInt())
    }

    private fun BudgetEntity.asBudget() = Budget(
        id = this.id.toString(),
        title = this.title,
        date = Date(this.date),
        recipient = this.recipient,
        items = emptyList()
    )

    private fun Budget.asEntity() = BudgetEntity(
        id = this.id?.toInt() ?: 0,
        title = this.title,
        date = this.date.time,
        recipient = this.recipient
    )

    private fun dao(budgetDatabase: BudgetDatabase) = lazy { budgetDatabase().budgetDao() }
}