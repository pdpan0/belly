package com.pdpano.belly.domain.ships

import java.time.LocalDateTime

class Ship(
    val id: Long,
    val name: String,
    val description: String,
    val logo: String?,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val createdBy: String
)