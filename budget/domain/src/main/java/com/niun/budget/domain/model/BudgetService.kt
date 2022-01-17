package com.niun.budget.domain.model

import java.math.BigDecimal

data class BudgetService(override val description: String, override val price: BigDecimal) :
    BudgetItem