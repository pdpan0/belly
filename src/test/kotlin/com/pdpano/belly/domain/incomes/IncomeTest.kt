package com.pdpano.belly.domain.incomes

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class IncomeTest {
    @Test
    fun `should create income instance`() =
        assertDoesNotThrow { Income(
            idIncome = 1,
            description = "Salário",
            amount = BigDecimal(2000),
            idShip = 1
        ) }

    //TODO: Inverter o assertDoesNotThrow
    @Test
    fun `should validate amount negative value`() =
        assertDoesNotThrow {
            Income(
                idIncome = 1,
                description = "Sálario",
                amount = BigDecimal(-200),
                idShip = 1
            )
        }

    @Test
    fun `should validate description is blank or empty`() =
        assertDoesNotThrow {
            Income(
                idIncome = 1,
                description = "   ",
                amount = BigDecimal(2000),
                idShip = 1
            )
        }
}

