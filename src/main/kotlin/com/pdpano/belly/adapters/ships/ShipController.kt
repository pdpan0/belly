package com.pdpano.belly.adapters.ships

import com.pdpano.belly.domain.ships.Ship
import com.pdpano.belly.usecase.ships.getshipsusecase.GetShipsUseCase
import com.pdpano.belly.usecase.ships.saveshipusecase.SaveShipInput
import com.pdpano.belly.usecase.ships.saveshipusecase.SaveShipUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Suppress("unused")
@RestController
@RequestMapping("/v1/ships")
class ShipController(
    private val saveShipUseCase: SaveShipUseCase,
    private val getShipsUseCase: GetShipsUseCase
) {

    @PostMapping
    fun saveShip(@RequestBody input: SaveShipInput): Long =
        saveShipUseCase.execute(input)

    @GetMapping
    fun getShips(): List<Ship> = getShipsUseCase.execute(null)

}