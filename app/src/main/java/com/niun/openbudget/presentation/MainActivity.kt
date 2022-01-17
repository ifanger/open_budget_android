package com.niun.openbudget.presentation

import android.os.Bundle
import android.view.LayoutInflater
import com.niun.core.base.BaseActivity
import com.niun.openbudget.databinding.ActivityMainBinding
import com.niun.router.budget.BudgetRoute
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val budgetRoute: BudgetRoute by inject()

    override fun onCreateBinding(layoutInflater: LayoutInflater) =
        ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = budgetRoute.getIntent(this)
        startActivity(intent)
    }
}