package com.pdpano.belly.infra.ships

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Ship Schema
 */

@Entity(name = "tb_ship")
class ShipSchema(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id_ship: Long?,
    val name: String,
    val description: String,
    val logo: String? = null,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val createdBy: String
)