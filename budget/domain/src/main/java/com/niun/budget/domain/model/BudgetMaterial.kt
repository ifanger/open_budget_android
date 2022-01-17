package com.niun.budget.domain.model

import java.math.BigDecimal

data class BudgetMaterial(override val description: String, override val price: BigDecimal) :
    BudgetItem
