package com.pdpano.belly.adapters.ships

import com.pdpano.belly.adapters.configurations.ResponseMessage
import com.pdpano.belly.domain.ships.Ship
import com.pdpano.belly.usecase.ships.getshipbyid.GetShipByIdInput
import com.pdpano.belly.usecase.ships.getshipbyid.GetShipByIdUseCase
import com.pdpano.belly.usecase.ships.getships.GetShipsUseCase
import com.pdpano.belly.usecase.ships.saveship.SaveShipInput
import com.pdpano.belly.usecase.ships.saveship.SaveShipUseCase
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
    fun saveShip(@RequestBody input: SaveShipInput): ResponseEntity<ResponseMessage<Long>> {
        val idShip = saveShipUseCase.execute(input)
        return ResponseEntity.created(URI("/v1/ships/$idShip")).body(
            ResponseMessage(success = true, response = idShip)
        )
    }

    @GetMapping
    fun getShips(): ResponseEntity<ResponseMessage<List<Ship>>> =
        ResponseEntity.ok(ResponseMessage(success = true, response = getShipsUseCase.execute(null)))

    @GetMapping("/{idShip}")
    fun getShipById(@PathVariable("idShip") idShip: Long): ResponseEntity<ResponseMessage<Ship>> =
        ResponseEntity.ok(ResponseMessage(success = true, response = getShipByIdUseCase.execute(GetShipByIdInput(idShip))))

}