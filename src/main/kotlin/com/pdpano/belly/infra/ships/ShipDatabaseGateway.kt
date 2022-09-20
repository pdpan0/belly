package com.pdpano.belly.infra.ships

import com.pdpano.belly.domain.ships.Ship
import com.pdpano.belly.domain.ships.ShipGateway
import org.springframework.stereotype.Repository

@Repository
class ShipDatabaseGateway(private val repository: ShipRepository): ShipGateway {
    override fun save(ship: Ship): Long {
        return repository.save(ShipSchema(
            id_ship = null,
            name = ship.name,
            description = ship.description,
            logo = ship.logo,
            createdAt = ship.createdAt,
            createdBy = ship.createdBy
        )).id_ship!!
    }
}