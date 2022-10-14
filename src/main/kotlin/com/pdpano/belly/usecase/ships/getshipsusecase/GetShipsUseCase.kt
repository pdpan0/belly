package com.pdpano.belly.usecase.ships.getshipsusecase

import com.pdpano.belly.domain.ships.Ship
import com.pdpano.belly.domain.ships.ShipGateway
import com.pdpano.belly.usecase.UseCase
import org.springframework.stereotype.Service

@Service
class GetShipsUseCase(private val shipGateway: ShipGateway): UseCase<Nothing?, List<Ship>> {
    override fun execute(input: Nothing?): List<Ship> =
        shipGateway.getShips()
}
