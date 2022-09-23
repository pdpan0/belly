package com.pdpano.belly.infra.ships

import org.springframework.data.jpa.repository.JpaRepository

interface ShipRepository: JpaRepository<ShipSchema, Long>