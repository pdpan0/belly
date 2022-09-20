package com.pdpano.belly.domain.ships

import java.time.LocalDateTime

class Ship(
    val id_ship: Long?,
    val name: String,
    description: String,
    val logo: String? = null,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val createdBy: String
) {
    val description: String = validateDescription(description)

    private fun validateDescription(value: String): String {
        require(value.length < 350) {
            "Description exceeded number of characters allowed"
        }

        return value
    }
}