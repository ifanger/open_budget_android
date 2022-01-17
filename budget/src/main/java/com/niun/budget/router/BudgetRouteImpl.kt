package com.niun.budget.router

import android.content.Context
import android.content.Intent
import com.niun.budget.presentation.BudgetActivity
import com.niun.router.budget.BudgetRoute

internal class BudgetRouteImpl : BudgetRoute {

    override fun getIntent(context: Context): Intent {
        return BudgetActivity.getLaunchIntent(context)
    }
}