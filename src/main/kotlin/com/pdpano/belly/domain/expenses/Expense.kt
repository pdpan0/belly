package com.pdpano.belly.domain.expenses

import com.pdpano.belly.domain.Budget
import java.math.BigDecimal
import java.time.LocalDateTime

class Expense(
    id: Long,
    description: String,
    amount: BigDecimal,
    createdAt: LocalDateTime = LocalDateTime.now(),
    idShip: Long
): Budget(id, description, amount, createdAt, idShip)