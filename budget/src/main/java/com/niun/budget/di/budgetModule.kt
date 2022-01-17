package com.niun.budget.di

import com.niun.budget.database.BudgetDatabase
import com.niun.budget.domain.repository.BudgetRepository
import com.niun.budget.domain.repository.BudgetRepositoryImpl
import com.niun.budget.domain.usecase.GetBudgetListUseCase
import com.niun.budget.domain.usecase.GetBudgetListUseCaseImpl
import com.niun.budget.presentation.list.viewmodel.ListViewModel
import com.niun.budget.router.BudgetRouteImpl
import com.niun.router.budget.BudgetRoute
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val routes = module {
    factory<BudgetRoute> { BudgetRouteImpl() }
}

private val providers = module {
    single { BudgetDatabase(androidApplication()) }
}

private val repositories = module {
    single<BudgetRepository> { BudgetRepositoryImpl(get()) }
}

private val useCases = module {
    factory<GetBudgetListUseCase> { GetBudgetListUseCaseImpl(get()) }
}

private val viewModels = module {
    viewModel { ListViewModel(get()) }
}

val budgetModules = routes + providers + repositories + useCases + viewModels