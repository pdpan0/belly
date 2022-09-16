package com.pdpano.belly.adapters.expenses

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne

/**
 * Expenses Entity
 */

@Entity
class ExpenseEntity(
    @Id val id: Long,
    val description: String,
    val amount: BigDecimal,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val id_ship: Long
)