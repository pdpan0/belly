package com.pdpano.belly.domain.ships

interface ShipGateway {
    fun save(ship: Ship): Long
}