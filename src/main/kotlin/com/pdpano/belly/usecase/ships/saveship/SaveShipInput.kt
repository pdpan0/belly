package com.pdpano.belly.usecase.ships.saveship

data class SaveShipInput(
    val name: String,
    val description: String,
    val logo: String? = null,
    val createdBy: String
)