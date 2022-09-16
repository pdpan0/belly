package com.pdpano.belly.domain.incomes

import com.pdpano.belly.domain.Budget
import java.math.BigDecimal
import java.time.LocalDateTime

class Income(
    id: Long,
    description: String,
    amount: BigDecimal,
    createdAt: LocalDateTime = LocalDateTime.now(),
    idShip: Long
): Budget(id, description, amount, createdAt, idShip)