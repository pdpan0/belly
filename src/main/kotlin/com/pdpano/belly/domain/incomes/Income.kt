package com.pdpano.belly.domain.incomes

import com.pdpano.belly.domain.Budget
import java.math.BigDecimal
import java.time.LocalDateTime

class Income(
    idIncome: Long?,
    description: String,
    amount: BigDecimal,
    createdAt: LocalDateTime = LocalDateTime.now(),
    idShip: Long
): Budget(idIncome, description, amount, createdAt, idShip)