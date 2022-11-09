package com.pdpano.belly.domain.expenses

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class ExpenseTest {
    @Test
    fun `should create expense instance`() =
        assertDoesNotThrow { Expense(
            idExpense = 1,
            description = "Conta de luz",
            amount = BigDecimal(500),
            idShip = 1
        ) }

    @Test
    fun `should validate amount negative value`() =
        assertDoesNotThrow {
            Expense(
                idExpense = 1,
                description = "Gastos com comida",
                amount = BigDecimal(-200),
                idShip = 1
            )
        }
}