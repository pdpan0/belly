package com.pdpano.belly.usecase.incomes.saveincomeusecase

import com.pdpano.belly.domain.NotFoundException
import com.pdpano.belly.domain.incomes.Income
import com.pdpano.belly.domain.incomes.IncomeGateway
import com.pdpano.belly.domain.ships.ShipGateway
import com.pdpano.belly.usecase.UseCase

class SaveIncomeUseCase(
    private val gateway: IncomeGateway,
    private val shipGateway: ShipGateway
): UseCase<SaveIncomeInput, Long> {
    override fun execute(input: SaveIncomeInput): Long {
        if (!shipGateway.existsById(input.idShip))
            throw NotFoundException("Ship")

        return gateway.save(Income(
            idIncome = null,
            description = input.description,
            amount = input.amount,
            idShip = input.idShip
        ))
    }

}