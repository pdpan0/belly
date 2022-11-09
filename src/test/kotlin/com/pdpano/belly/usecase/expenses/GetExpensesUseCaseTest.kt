package com.pdpano.belly.usecase.expenses

import com.pdpano.belly.domain.expenses.Expense
import com.pdpano.belly.domain.expenses.ExpenseGateway
import com.pdpano.belly.usecase.expenses.getexpenses.GetExpensesUseCase
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.math.BigDecimal


internal class GetExpensesUseCaseTest {
    private val mockExpenses = listOf(
        Expense(
            idExpense = 1L,
            description = "Conta de água",
            amount = BigDecimal(500),
            idShip = 1L
        ),
        Expense(
            idExpense = 2L,
            description = "Conta de luz",
            amount = BigDecimal(600),
            idShip = 1L
        )
    )

    private val gateway: ExpenseGateway = mockk {
        every { findAllBudget() } returns mockExpenses
    }

    private val getExpensesUseCase = GetExpensesUseCase(gateway)

    @Test
    fun `should get all expenses`() {
        Assertions.assertEquals(mockExpenses, getExpensesUseCase.execute(null))
    }
}