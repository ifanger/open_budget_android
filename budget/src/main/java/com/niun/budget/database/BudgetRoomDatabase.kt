package com.niun.budget.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.niun.budget.database.dao.BudgetDao
import com.niun.budget.database.dao.BudgetItemDao
import com.niun.budget.database.entity.BudgetEntity
import com.niun.budget.database.entity.BudgetItemEntity

@Database(
    entities = [BudgetEntity::class, BudgetItemEntity::class], version = 1
)
internal abstract class BudgetRoomDatabase : RoomDatabase() {
    abstract fun budgetDao(): BudgetDao
    abstract fun budgetItemDao(): BudgetItemDao
}