package com.pdpano.belly.domain.ships

interface ShipGateway {
    fun save(ship: Ship): Long
    fun findShipByIdShip(idShip: Long): Ship?

    fun existsById(idShip: Long): Boolean
}