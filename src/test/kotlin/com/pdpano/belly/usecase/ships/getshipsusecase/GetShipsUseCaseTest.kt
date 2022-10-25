package com.pdpano.belly.usecase.ships.getshipsusecase

import com.pdpano.belly.domain.ships.ShipGateway
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

internal class GetShipsUseCaseTest {
    private val gateway: ShipGateway = mockk {
        every { getShips() } returns listOf()
    }

    private val getShipUseCase = GetShipsUseCase(gateway)
    @Test
    fun `should get all ships from database`() {
        getShipUseCase.execute(null)
        verify(exactly = 1) { gateway.getShips() }
    }
}