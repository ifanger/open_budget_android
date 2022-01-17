package com.niun.budget.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "budget_item")
internal data class BudgetItemEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "price") val price: Float
)