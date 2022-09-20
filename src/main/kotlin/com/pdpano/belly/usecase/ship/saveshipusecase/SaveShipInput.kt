package com.pdpano.belly.usecase.ship.saveshipusecase

data class SaveShipInput(
    val name: String,
    val description: String,
    val logo: String? = null,
    val createdBy: String
)