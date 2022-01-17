package com.niun.budget.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.niun.budget.database.entity.BudgetEntity

@Dao
internal interface BudgetDao {
    @Query("SELECT * FROM budget")
    suspend fun getAll(): List<BudgetEntity>

    @Query("SELECT * FROM budget WHERE id = :id")
    suspend fun getById(id: Int): BudgetEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(budget: BudgetEntity)

    @Query("DELETE FROM budget WHERE id = :id")
    suspend fun delete(id: Int)
}