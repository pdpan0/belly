package com.pdpano.belly.infra.incomes

import com.pdpano.belly.domain.Budget
import com.pdpano.belly.domain.incomes.Income
import com.pdpano.belly.domain.incomes.IncomeGateway
import org.springframework.stereotype.Repository
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.YearMonth

@Repository
class IncomeDatabaseGateway(private val repository: IncomeRepository): IncomeGateway {
    override fun save(budget: Budget): Long {
        return repository.save(
            IncomeSchema(
                idIncome = null,
                description = budget.description,
                amount = budget.amount,
                idShip = budget.idShip
            )
        ).idIncome!!
    }

    override fun existsByDescriptionAndCurrentMonth(description: String): Boolean {
        val month = YearMonth.from(LocalDate.now())
        return repository.existsByDescriptionAndMonth(
            description,
            month.atDay(1).atTime(0,0),
            month.atEndOfMonth().atTime(0,0)
        )
    }

    override fun findAllBudget(): List<Income> =
        repository.findAll().map { it.mapToDomain() }

    private fun IncomeSchema.mapToDomain(): Income =
        Income(idIncome, description, amount, createdAt, idShip)
}