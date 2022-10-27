package com.pdpano.belly.usecase.incomes.saveincomeusecase

import com.pdpano.belly.domain.NotFoundException
import com.pdpano.belly.domain.incomes.Income
import com.pdpano.belly.domain.incomes.IncomeGateway
import com.pdpano.belly.domain.ships.ShipGateway
import com.pdpano.belly.usecase.UseCase
import org.springframework.stereotype.Service

@Service
class SaveIncomeUseCase(
    private val gateway: IncomeGateway,
    private val shipGateway: ShipGateway
): UseCase<SaveIncomeInput, Long> {
    override fun execute(input: SaveIncomeInput): Long {
        if (!shipGateway.existsById(input.idShip))
            throw NotFoundException("Ship")

        if (gateway.existsByDescriptionAndCurrentMonth(input.description))
            throw IllegalArgumentException("Already exists a income with same description in current month.")

        return gateway.save(Income(
            idIncome = null,
            description = input.description,
            amount = input.amount,
            idShip = input.idShip
        ))
    }

}