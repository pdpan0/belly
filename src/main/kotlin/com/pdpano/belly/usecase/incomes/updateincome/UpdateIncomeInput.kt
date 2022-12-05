package com.pdpano.belly.usecase.incomes.updateincome

import java.math.BigDecimal

data class UpdateIncomeInput(
    val idExpense: Long,
    val description: String,
    val amount: BigDecimal,
    val idShip: Long
)