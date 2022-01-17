package com.niun.budget.domain.model

import java.util.Date

data class Budget(
    val id: String?,
    val title: String,
    val date: Date,
    val recipient: String,
    val items: List<BudgetItem>
)