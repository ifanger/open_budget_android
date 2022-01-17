package com.niun.budget.presentation.list.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.niun.budget.databinding.ItemBudgetBinding
import com.niun.budget.domain.model.Budget
import com.niun.core.ext.getLayoutInflater
import java.util.Locale

internal class BudgetAdapter(
    private val budgets: List<Budget>,
    private val onItemClick: (budget: Budget) -> Unit
) : RecyclerView.Adapter<BudgetAdapter.BudgetViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BudgetViewHolder {
        val binding = ItemBudgetBinding.inflate(
            parent.getLayoutInflater(),
            parent,
            false
        )

        return BudgetViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BudgetViewHolder, position: Int) {
        holder.bind(budgets[position])
    }

    override fun getItemCount(): Int = budgets.size

    inner class BudgetViewHolder(private val binding: ItemBudgetBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(budget: Budget) = with(binding) {
            root.setOnClickListener { onItemClick(budget) }
            budgetTitle.text = budget.title
            budgetPrice.text =
                String.format(Locale.getDefault(), "%.2f", budget.items.sumOf { it.price })
        }
    }
}