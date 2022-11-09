package com.pdpano.belly.usecase.expenses.getexpensebyid

import com.pdpano.belly.domain.expenses.Expense
import com.pdpano.belly.domain.expenses.ExpenseGateway
import com.pdpano.belly.usecase.UseCase
import org.springframework.stereotype.Service

@Service
class GetExpenseByIdUseCase(private val gateway: ExpenseGateway): UseCase<Long, Expense> {
    override fun execute(input: Long): Expense {
        return gateway.findBudgetById(input)
    }
}