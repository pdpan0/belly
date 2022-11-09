package com.pdpano.belly.usecase.expenses.saveexpense

import java.math.BigDecimal

data class SaveExpenseInput(
    val description: String,
    val amount: BigDecimal,
    val idShip: Long
)