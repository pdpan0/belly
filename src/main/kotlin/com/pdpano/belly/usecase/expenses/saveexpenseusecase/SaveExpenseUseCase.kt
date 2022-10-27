package com.pdpano.belly.usecase.expense.saveexpenseusecase

import com.pdpano.belly.domain.NotFoundException
import com.pdpano.belly.domain.expenses.Expense
import com.pdpano.belly.domain.expenses.ExpenseGateway
import com.pdpano.belly.domain.ships.ShipGateway
import com.pdpano.belly.usecase.UseCase
import com.pdpano.belly.usecase.expenses.saveexpenseusecase.SaveExpenseInput
import org.springframework.stereotype.Service

@Service
class SaveExpenseUseCase(
    private val gateway: ExpenseGateway,
    private val shipGateway: ShipGateway
): UseCase<SaveExpenseInput, Long> {

    override fun execute(input: SaveExpenseInput): Long {
        if (!shipGateway.existsById(input.idShip))
            throw NotFoundException("Ship")

        if (gateway.existsByDescriptionAndCurrentMonth(input.description))
            throw IllegalArgumentException("Already exists a expense with same description in current month.")

        return gateway.save(Expense(
            idExpense = null,
            description = input.description,
            amount = input.amount,
            idShip = input.idShip
        ))
    }

}