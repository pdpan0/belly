package com.pdpano.belly.domain.expenses

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.Id

/**
 * Expenses Entity
 */

@Entity
class Expense(
    @Id val id: Long,
    val description: String,
    val amount: BigDecimal,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val id_ship: Long
)