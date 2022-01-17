package com.niun.budget.di

import com.niun.budget.domain.usecase.GetBudgetListUseCase
import com.niun.budget.domain.usecase.GetBudgetListUseCaseImpl
import com.niun.budget.presentation.list.viewmodel.ListViewModel
import com.niun.budget.router.BudgetRouteImpl
import com.niun.router.budget.BudgetRoute
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val routes = module {
    factory<BudgetRoute> { BudgetRouteImpl() }
}

private val repositories = module { }

private val useCases = module {
    factory<GetBudgetListUseCase> { GetBudgetListUseCaseImpl() }
}

private val viewModels = module {
    viewModel { ListViewModel(get()) }
}

val budgetModules = routes + repositories + useCases + viewModels