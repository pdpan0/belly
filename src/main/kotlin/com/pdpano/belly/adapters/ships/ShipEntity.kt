package com.pdpano.belly.adapters.ships

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.Id

/**
 * Ship Entity
 */

@Entity
class ShipEntity(
    @Id
    val id: Long,
    val name: String,
    val description: String,
    val logo: String?,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val createdBy: String
) {
}