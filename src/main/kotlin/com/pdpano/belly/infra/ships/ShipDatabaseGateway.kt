package com.pdpano.belly.infra.ships

import com.pdpano.belly.domain.ships.Ship
import com.pdpano.belly.domain.ships.ShipGateway
import org.springframework.stereotype.Repository

@Repository
class ShipDatabaseGateway(private val repository: ShipRepository): ShipGateway {
    override fun save(ship: Ship): Long {
        return repository.save(ShipSchema(
            idShip = null,
            name = ship.name,
            description = ship.description,
            logo = ship.logo,
            createdAt = ship.createdAt,
            createdBy = ship.createdBy
        )).idShip!!
    }

    override fun findShipByIdShip(idShip: Long): Ship? {
        val ship = repository.findById(idShip)
        return if (ship.isPresent) ship.get().let(::mapToDomain) else null
    }

    override fun existsById(idShip: Long): Boolean = repository.existsById(idShip)

    override fun getShips(): List<Ship> = repository.findAll().map(::mapToDomain)

    private fun mapToDomain(schema: ShipSchema): Ship =
        Ship(
            idShip = schema.idShip,
            name = schema.name,
            description = schema.description,
            logo = schema.logo,
            createdAt = schema.createdAt,
            createdBy = schema.createdBy
        )
}