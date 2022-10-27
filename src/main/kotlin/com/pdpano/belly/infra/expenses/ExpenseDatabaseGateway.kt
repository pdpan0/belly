package com.pdpano.belly.infra.expenses

import com.pdpano.belly.domain.Budget
import com.pdpano.belly.domain.expenses.Expense
import com.pdpano.belly.domain.expenses.ExpenseGateway
import com.pdpano.belly.domain.incomes.Income
import com.pdpano.belly.infra.incomes.IncomeSchema
import org.springframework.stereotype.Repository
import java.time.LocalDate
import java.time.YearMonth

@Repository
class ExpenseDatabaseGateway(private val repository: ExpenseRepository): ExpenseGateway {
    override fun save(budget: Budget): Long {
        return repository.save(
            ExpenseSchema(
            idIncome = null,
            description = budget.description,
            amount = budget.amount,
            idShip = budget.idShip
        )).idIncome!!
    }

    override fun existsByDescriptionAndCurrentMonth(description: String): Boolean {
        val month = YearMonth.from(LocalDate.now())
        return repository.existsByDescriptionAndMonth(
            description,
            month.atDay(1).atTime(0,0),
            month.atEndOfMonth().atTime(0,0)
        )
    }

    override fun findAllBudget(): List<Expense> =
        repository.findAll().map { it.mapToDomain() }

    private fun ExpenseSchema.mapToDomain(): Expense =
        Expense(idIncome, description, amount, createdAt, idShip)

}