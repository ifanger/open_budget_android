package com.niun.budget.domain.model

import java.math.BigDecimal

data class BudgetDiscount(override val description: String, override val price: BigDecimal) :
    BudgetItem
