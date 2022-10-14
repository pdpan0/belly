package com.pdpano.belly.infra.expenses

import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Expense Schema
 */

@Entity
class ExpenseSchema(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idExpense: Long?,
    val description: String,
    val amount: BigDecimal,
    val idShip: Long,
)