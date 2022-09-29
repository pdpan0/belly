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
    }
    private val shipGateway: ShipGateway = mockk {
        every { save(any()) } returns 1L
        every { existsById(any()) } returns true
    }

    private val saveIncome = SaveIncomeUseCase(gateway, shipGateway)

    @Test
    fun `should save a ship in table`() {
        val income = SaveIncomeInput(
            description = "Gasto com comida.",
            amount = BigDecimal(300),
            idShip = 1
        )

        assertEquals(1L, saveIncome.execute(income))
    }
}

