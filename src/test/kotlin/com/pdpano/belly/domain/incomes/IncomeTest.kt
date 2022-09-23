package com.pdpano.belly.domain.incomes

import com.pdpano.belly.domain.expenses.Expense
import org.junit.jupiter.api.Assertions.*
import java.math.BigDecimal

internal class IncomeTest {
    fun `should create income instance`() =
        assertDoesNotThrow { Income(
            id = 1,
            description = "Salário",
            amount = BigDecimal(2000),
            idShip = 1
        ) }
}

