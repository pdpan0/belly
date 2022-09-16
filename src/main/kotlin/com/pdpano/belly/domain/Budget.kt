package com.pdpano.belly.domain

import java.math.BigDecimal
import java.time.LocalDateTime

abstract class Budget(
    val id: Long,
    val description: String,
    val amount: BigDecimal,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val id_ship: Long,
)