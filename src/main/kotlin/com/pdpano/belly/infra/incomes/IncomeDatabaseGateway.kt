package com.pdpano.belly.infra.incomes

import com.pdpano.belly.domain.Budget
import com.pdpano.belly.domain.incomes.IncomeGateway
import org.springframework.stereotype.Repository

@Repository
class IncomeDatabaseGateway(private val repository: IncomeRepository): IncomeGateway {
    override fun save(budget: Budget): Long {
        return repository.save(IncomeSchema(
            idIncome = null,
            description = budget.description,
            amount = budget.amount,
            idShip = budget.idShip
        )).idIncome!!
    }

    override fun existsByDescriptionAndCurrentMonth(description: String): Boolean {
        return repository.existsByDescriptionAndCurrentMonth(description)
    }
}