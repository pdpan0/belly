package com.pdpano.belly.adapters.ships

import com.pdpano.belly.adapters.configurations.ResponseMessage
import com.pdpano.belly.domain.ships.Ship
import com.pdpano.belly.usecase.ships.getshipbyidusecase.GetShipByIdInput
import com.pdpano.belly.usecase.ships.getshipbyidusecase.GetShipByIdUseCase
import com.pdpano.belly.usecase.ships.getshipsusecase.GetShipsUseCase
import com.pdpano.belly.usecase.ships.saveshipusecase.SaveShipInput
import com.pdpano.belly.usecase.ships.saveshipusecase.SaveShipUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@Suppress("unused")
@RestController
@RequestMapping("/v1/ships")
class ShipController(
    private val saveShipUseCase: SaveShipUseCase,
    private val getShipsUseCase: GetShipsUseCase,
    private val getShipByIdUseCase: GetShipByIdUseCase,
) {

    @PostMapping
    fun saveShip(@RequestBody input: SaveShipInput): ResponseEntity<ResponseMessage<Long>> =
        ResponseEntity.created(URI("/v1/ships/{idShip}")).body(
            ResponseMessage(success = true, response = saveShipUseCase.execute(input)))

    @GetMapping
    fun getShips(): ResponseEntity<ResponseMessage<List<Ship>>> =
        ResponseEntity.ok(ResponseMessage(success = true, response = getShipsUseCase.execute(null)))

    @GetMapping("/{idShip}")
    fun getShipById(@PathVariable("idShip") idShip: Long): ResponseEntity<ResponseMessage<Ship>> =
        ResponseEntity.ok(ResponseMessage(success = true, response = getShipByIdUseCase.execute(GetShipByIdInput(idShip))))

}