package com.niun.router.budget

import android.content.Context
import android.content.Intent

interface BudgetRoute {

    fun getIntent(context: Context): Intent
}