package com.pdpano.belly.domain.incomes

import com.pdpano.belly.domain.Budget
import com.pdpano.belly.domain.BudgetFactory

interface IncomeGateway: BudgetFactory {
    override fun save(budget: Budget): Long
}