package com.pdpano.belly.usecase.expense.saveexpenseusecase

import com.pdpano.belly.domain.expenses.ExpenseGateway
import com.pdpano.belly.domain.ships.ShipGateway
import com.pdpano.belly.usecase.expenses.saveexpenseusecase.SaveExpenseInput
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class SaveExpenseUseCaseTest {
    private val gateway: ExpenseGateway = mockk {
        every { save(any()) } returns 1L
        every { existsByDescriptionAndCurrentMonth("Comida") } returns true
        every { existsByDescriptionAndCurrentMonth("Conta de água") } returns false
    }
    private val shipGateway: ShipGateway = mockk {
        every { save(any()) } returns 1L
        every { existsById(any()) } returns true
    }

    private val saveExpense = SaveExpenseUseCase(gateway, shipGateway)

    @Test
    fun `should save a expense in table`() {
        val expense = SaveExpenseInput(
            description = "Conta de água",
            amount = BigDecimal(500),
            idShip = 1
        )

        assertEquals(1L, saveExpense.execute(expense))
    }

    @Test
    fun `should'nt save a expense with description existing in current month`() {
        val expense = SaveExpenseInput(
            description = "Comida",
            amount = BigDecimal(300),
            idShip = 1
        )

        assertThrows(IllegalArgumentException::class.java) {
            saveExpense.execute(expense)
        }
    }

}