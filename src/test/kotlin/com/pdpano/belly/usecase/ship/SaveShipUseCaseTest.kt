package com.pdpano.belly.usecase.ship

import com.pdpano.belly.domain.ships.ShipGateway
import com.pdpano.belly.usecase.ship.saveshipusecase.SaveShipInput
import com.pdpano.belly.usecase.ship.saveshipusecase.SaveShipUseCase
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SaveShipUseCaseTest {
    private val repository: ShipGateway = mockk {
        every { save(any()) } returns 1L
    }

    private val saveShipUseCase = SaveShipUseCase(repository)

    @Test
    fun `should save a ship in table`() {
        val ship = SaveShipInput(
            name = "Thousand Sunny",
            description = "Thousand Sunny é o segundo navio dos Chapéu de Palha, e atualmente seu principal meio de transporte após a destruição do Going Merry.",
            createdBy = "lucas.martins"
        )

        assertEquals(1L, saveShipUseCase.execute(ship))
    }
}