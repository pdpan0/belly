package com.pdpano.belly.domain.incomes

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.Id

/**
 * Incomes Entity
 */

@Entity
class Income(
    @Id
    val id: Long,
    val description: String,
    val amount: BigDecimal,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val id_ship: Long
)