package com.pdpano.belly.domain.expenses

import com.pdpano.belly.domain.Budget
import com.pdpano.belly.domain.BudgetFactory

interface ExpenseGateway: BudgetFactory {
    override fun save(budget: Budget): Long
    override fun existsByDescriptionAndCurrentMonth(description: String): Boolean
    override fun findAllBudget(): List<Expense>
}