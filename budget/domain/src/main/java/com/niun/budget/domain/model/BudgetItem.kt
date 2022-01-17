package com.niun.budget.domain.model

import java.math.BigDecimal

interface BudgetItem {
    val description: String
    val price: BigDecimal
}