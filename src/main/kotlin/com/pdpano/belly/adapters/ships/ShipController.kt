package com.pdpano.belly.adapters.ships

import com.pdpano.belly.usecase.ship.saveshipusecase.SaveShipInput
import com.pdpano.belly.usecase.ship.saveshipusecase.SaveShipUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Suppress("unused")
@RestController
@RequestMapping("/v1/ships")
class ShipController(private val saveShipUseCase: SaveShipUseCase) {

    @PostMapping
    fun saveShip(@RequestBody input: SaveShipInput): Long =
        saveShipUseCase.execute(input)

}