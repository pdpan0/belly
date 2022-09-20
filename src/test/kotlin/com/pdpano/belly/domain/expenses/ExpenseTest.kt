package com.pdpano.belly.domain.expenses

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class ExpenseTest {
    @Test
    fun `should create expense instance`() =
        assertDoesNotThrow { Expense(
            id = 1,
            description = "Conta de luz",
            amount = BigDecimal(500),
            idShip = 1
        ) }
}