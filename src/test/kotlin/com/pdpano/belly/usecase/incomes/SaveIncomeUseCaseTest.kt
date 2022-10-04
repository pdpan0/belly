package com.pdpano.belly.usecase.incomes

import com.pdpano.belly.domain.incomes.IncomeGateway
import com.pdpano.belly.domain.ships.ShipGateway
import com.pdpano.belly.usecase.incomes.saveincomeusecase.SaveIncomeInput
import com.pdpano.belly.usecase.incomes.saveincomeusecase.SaveIncomeUseCase
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class SaveIncomeUseCaseTest {
    private val gateway: IncomeGateway = mockk {
        every { save(any()) } returns 1L
        every { existsByDescriptionAndCurrentMonth("Salário") } returns true
        every { existsByDescriptionAndCurrentMonth("Tesouro Direto") } returns false
    }
    private val shipGateway: ShipGateway = mockk {
        every { save(any()) } returns 1L
        every { existsById(any()) } returns true
    }

    private val saveIncome = SaveIncomeUseCase(gateway, shipGateway)

    @Test
    fun `should save a income in table`() {
        val income = SaveIncomeInput(
            description = "Tesouro Direto",
            amount = BigDecimal(500),
            idShip = 1
        )

        assertEquals(1L, saveIncome.execute(income))
    }

    @Test
    fun `should'nt save a income with description existing in current month`() {
        val income = SaveIncomeInput(
            description = "Salário",
            amount = BigDecimal(300),
            idShip = 1
        )

        assertThrows(IllegalArgumentException::class.java) {
            saveIncome.execute(income)
        }
    }
}

