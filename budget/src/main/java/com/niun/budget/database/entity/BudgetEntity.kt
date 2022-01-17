package com.niun.budget.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "budget")
internal data class BudgetEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "date") val date: Long,
    @ColumnInfo(name = "recipient") val recipient: String,
)