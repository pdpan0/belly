package com.pdpano.belly.usecase.incomes.updateincome

import com.pdpano.belly.domain.incomes.Income
import com.pdpano.belly.domain.incomes.IncomeGateway
import com.pdpano.belly.usecase.UseCase
import org.springframework.stereotype.Service

@Service
class UpdateIncomeUseCase(private val gateway: IncomeGateway): UseCase<UpdateIncomeInput, Nothing?> {
    override fun execute(input: UpdateIncomeInput): Nothing? {
        //TODO: Validar income

        gateway.updateBudget(Income(
            idIncome = input.idExpense,
            description = input.description,
            amount = input.amount,
            idShip = input.idShip
        ))

        return null
    }
}