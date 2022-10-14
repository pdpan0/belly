package com.pdpano.belly.infra.incomes

import com.pdpano.belly.domain.Budget
import com.pdpano.belly.domain.incomes.IncomeGateway
import com.pdpano.belly.infra.expenses.ExpenseSchema
import com.pdpano.belly.infra.expenses.ExpenseRepository
import org.springframework.stereotype.Repository

@Repository
class IncomeDatabaseGateway(private val repository: ExpenseRepository): IncomeGateway {
    override fun save(budget: Budget): Long {
        return repository.save(
            ExpenseSchema(
            idExpense = null,
            description = budget.description,
            amount = budget.amount,
            idShip = budget.idShip
        )
        ).idExpense!!
    }

    override fun existsByDescriptionAndCurrentMonth(description: String): Boolean {
        return repository.existsByDescriptionAndCurrentMonth(description)
    }
}