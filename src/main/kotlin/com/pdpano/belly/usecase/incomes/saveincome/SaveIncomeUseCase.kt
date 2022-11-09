package com.pdpano.belly.usecase.incomes.saveincome

import com.pdpano.belly.domain.exceptions.ConflictException
import com.pdpano.belly.domain.exceptions.NotFoundException
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
            throw ConflictException("INCOME", "Already exists a income with same description in current month.")

        return gateway.save(Income(
            idIncome = null,
            description = input.description,
            amount = input.amount,
            idShip = input.idShip
        ))
    }

}