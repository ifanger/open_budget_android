package com.niun.budget.presentation

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import com.niun.budget.databinding.ActivityBudgetBinding
import com.niun.core.base.BaseActivity

internal class BudgetActivity : BaseActivity<ActivityBudgetBinding>() {

    override fun onCreateBinding(layoutInflater: LayoutInflater) =
        ActivityBudgetBinding.inflate(layoutInflater)

    companion object {
        fun getLaunchIntent(context: Context): Intent {
            return Intent(context, BudgetActivity::class.java)
        }
    }
}