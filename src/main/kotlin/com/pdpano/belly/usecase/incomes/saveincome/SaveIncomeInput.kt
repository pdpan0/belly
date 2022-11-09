package com.pdpano.belly.usecase.incomes.saveincome

import java.math.BigDecimal

data class SaveIncomeInput(
    val description: String,
    val amount: BigDecimal,
    val idShip: Long
)