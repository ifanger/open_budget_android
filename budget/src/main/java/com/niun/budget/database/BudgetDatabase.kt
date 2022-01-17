package com.niun.budget.database

import android.content.Context
import androidx.room.Room

internal class BudgetDatabase(
    private val context: Context
) {

    private val roomDatabase: BudgetRoomDatabase by lazy {
        Room
            .databaseBuilder(context, BudgetRoomDatabase::class.java, DATABASE_NAME)
            .build()
    }

    operator fun invoke(): BudgetRoomDatabase {
        return roomDatabase
    }

    private companion object {
        const val DATABASE_NAME = "budget-database"
    }
}