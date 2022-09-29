package com.pdpano.belly.infra.incomes

import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Income Schema
 */

@Entity
class IncomeSchema(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idIncome: Long?,
    val description: String,
    val amount: BigDecimal,
    val idShip: Long,
)