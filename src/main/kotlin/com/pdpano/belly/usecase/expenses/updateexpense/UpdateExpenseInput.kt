package com.pdpano.belly.usecase.expenses.updateexpense

import java.math.BigDecimal

data class UpdateExpenseInput(
    val idExpense: Long,
    val description: String,
    val amount: BigDecimal,
    val idShip: Long
)