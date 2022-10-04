package com.pdpano.belly.domain

import java.math.BigDecimal
import java.time.LocalDateTime

abstract class Budget(
    val id: Long?,
    description: String,
    amount: BigDecimal,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val idShip: Long,
) {
    val description: String = validateDescription(description)
    val amount = validateAmount(amount)

    private fun validateAmount(value: BigDecimal): BigDecimal {
        require(value > BigDecimal.ZERO) {
            "Amount shouldn't be negative value"
        }

        return value
    }

    private fun validateDescription(value: String): String {
        require(value.isNotBlank()) {
            "Description shouldn't be blank or empty"
        }

        return value
    }
}