package com.pdpano.belly.usecase.ships.getshipbyid

import com.pdpano.belly.domain.exceptions.NotFoundException
import com.pdpano.belly.domain.ships.Ship
import com.pdpano.belly.domain.ships.ShipGateway
import com.pdpano.belly.usecase.UseCase
import org.springframework.stereotype.Service

@Service
class GetShipByIdUseCase(private val shipGateway: ShipGateway): UseCase<GetShipByIdInput, Ship> {
    override fun execute(input: GetShipByIdInput): Ship =
        shipGateway.findShipByIdShip(input.idShip) ?: throw NotFoundException("Ship")
}
