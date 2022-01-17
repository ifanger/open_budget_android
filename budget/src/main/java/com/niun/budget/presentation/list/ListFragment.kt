package com.niun.budget.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.niun.budget.databinding.FragmentListBinding
import com.niun.budget.domain.model.Budget
import com.niun.budget.presentation.list.adapter.BudgetAdapter
import com.niun.budget.presentation.list.viewmodel.ListViewModel
import com.niun.budget.presentation.list.viewmodel.action.ListViewAction
import com.niun.budget.presentation.list.viewmodel.event.ListViewEvent
import com.niun.budget.presentation.list.viewmodel.state.ListViewState
import com.niun.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class ListFragment :
    BaseFragment<ListViewState, ListViewEvent, ListViewAction, ListViewModel, FragmentListBinding>() {

    override val viewModel: ListViewModel by viewModel()

    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentListBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadBudgets()
    }

    override fun onStateChanged(newState: ListViewState?) {
        when (newState) {
            is ListViewState.Loading -> setLoadingState()
            is ListViewState.Success -> setSuccessState(newState.budgets)
            is ListViewState.Error -> setErrorState()
        }
    }

    private fun setLoadingState() {
        updateVisibility(
            loadingVisible = true,
            successVisible = false
        )
    }

    private fun setSuccessState(budgets: List<Budget>) {
        updateVisibility(
            loadingVisible = false,
            successVisible = true
        )

        fillRecyclerView(budgets)
    }

    private fun fillRecyclerView(budgets: List<Budget>) = with(binding) {
        val adapter = BudgetAdapter(budgets, ::onBudgetClick)

        budgetList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        budgetList.setHasFixedSize(true)
        budgetList.adapter = adapter
    }

    private fun onBudgetClick(budget: Budget) {
        budget.id?.let { budgetId ->
            viewModel.sendAction(ListViewAction.ViewDetails(budgetId))
        }
    }

    private fun setErrorState() {
        updateVisibility(
            loadingVisible = false,
            successVisible = false
        )
    }

    private fun updateVisibility(loadingVisible: Boolean, successVisible: Boolean) = with(binding) {
        progressBar.isVisible = loadingVisible
        successGroup.isVisible = successVisible
    }

    override fun onEventChanged(event: ListViewEvent?) {
        when (event) {
            is ListViewEvent.OpenDetails -> openDetails(event.id)
            is ListViewEvent.ShowError -> showError()
        }
    }

    private fun openDetails(id: String) {
        val navController = findNavController()
        navController.navigate(ListFragmentDirections.actionListFragmentToDetailsFragment(id))
    }

    private fun showError() {
        Toast.makeText(requireContext(), "Houve um erro ao carregar", Toast.LENGTH_LONG).show()
    }
}