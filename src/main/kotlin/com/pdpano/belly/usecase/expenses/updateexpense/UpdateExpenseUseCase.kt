package com.pdpano.belly.usecase.expenses.updateexpense

import com.pdpano.belly.domain.expenses.Expense
import com.pdpano.belly.domain.expenses.ExpenseGateway
import com.pdpano.belly.usecase.UseCase
import org.springframework.stereotype.Service

@Service
class UpdateExpenseUseCase(private val gateway: ExpenseGateway): UseCase<UpdateExpenseInput, Nothing?> {
    override fun execute(input: UpdateExpenseInput): Nothing? {
        //TODO: Validar expense

        gateway.updateBudget(Expense(
            idExpense = input.idExpense,
            description = input.description,
            amount = input.amount,
            idShip = input.idShip
        ))

        return null
    }
}