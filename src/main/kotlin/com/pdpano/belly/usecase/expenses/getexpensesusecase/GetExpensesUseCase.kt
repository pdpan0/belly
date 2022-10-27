package com.pdpano.belly.usecase.expenses.getexpensesusecase

import com.pdpano.belly.domain.expenses.Expense
import com.pdpano.belly.domain.expenses.ExpenseGateway
import com.pdpano.belly.usecase.UseCase
import org.springframework.stereotype.Service

@Service
class GetExpensesUseCase(
    private val gateway: ExpenseGateway
): UseCase<Nothing?, List<Expense>> {
    override fun execute(input: Nothing?): List<Expense> =
        gateway.findAllBudget()

}