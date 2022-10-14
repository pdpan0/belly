package com.pdpano.belly.usecase.expenses.saveexpenseusecase

import java.math.BigDecimal

data class SaveExpenseInput(
    val description: String,
    val amount: BigDecimal,
    val idShip: Long
)