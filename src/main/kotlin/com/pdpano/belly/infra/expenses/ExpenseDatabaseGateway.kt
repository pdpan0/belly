package com.pdpano.belly.infra.expenses

import com.pdpano.belly.domain.Budget
import com.pdpano.belly.domain.expenses.ExpenseGateway
import org.springframework.stereotype.Repository

@Repository
class ExpenseDatabaseGateway(private val repository: ExpenseRepository): ExpenseGateway {
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