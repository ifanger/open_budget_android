package com.niun.openbudget

import android.app.Application
import com.niun.budget.di.budgetModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class OpenBudgedApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin()
    }

    private fun startKoin() {
        startKoin {
            androidLogger()
            androidContext(this@OpenBudgedApplication)
            modules(budgetModules)
        }
    }
}