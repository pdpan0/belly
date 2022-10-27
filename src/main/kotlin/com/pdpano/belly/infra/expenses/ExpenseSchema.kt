package com.pdpano.belly.infra.expenses

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Expense Schema
 */

@Entity(name = "tb_expenses")
class ExpenseSchema(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idIncome: Long?,
    val description: String,
    val amount: BigDecimal,
    val idShip: Long,
    val createdAt: LocalDateTime = LocalDateTime.now(),
)