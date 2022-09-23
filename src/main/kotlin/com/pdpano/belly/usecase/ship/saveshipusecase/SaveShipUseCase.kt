package com.pdpano.belly.usecase.ship.saveshipusecase

import com.pdpano.belly.domain.ships.Ship
import com.pdpano.belly.domain.ships.ShipGateway
import com.pdpano.belly.usecase.UseCase
import org.springframework.stereotype.Service

@Service
class SaveShipUseCase(private val shipGateway: ShipGateway): UseCase<SaveShipInput, Long> {
    override fun execute(input: SaveShipInput): Long {
        return shipGateway.save(
            Ship(
                id_ship = null,
                name = input.name,
                description = input.description,
                logo = input.logo,
                createdBy = input.createdBy
            )
        )
    }
}