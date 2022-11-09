package com.pdpano.belly.domain.incomes

import com.pdpano.belly.domain.Budget
import com.pdpano.belly.domain.BudgetFactory

interface IncomeGateway: BudgetFactory {
    override fun save(budget: Budget): Long
    override fun existsByDescriptionAndCurrentMonth(description: String): Boolean
    override fun findAllBudget(): List<Income>
    override fun findBudgetById(idBudget: Long): Income
    override fun updateBudget(budget: Budget)
}