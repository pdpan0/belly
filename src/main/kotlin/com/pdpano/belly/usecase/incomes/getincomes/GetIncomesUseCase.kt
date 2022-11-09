package com.pdpano.belly.usecase.incomes.getincomes

import com.pdpano.belly.domain.incomes.Income
import com.pdpano.belly.domain.incomes.IncomeGateway
import com.pdpano.belly.usecase.UseCase
import org.springframework.stereotype.Service

@Service
class GetIncomesUseCase(
    private val incomeGateway: IncomeGateway
): UseCase<Nothing?, List<Income>> {
    override fun execute(input: Nothing?): List<Income> =
        incomeGateway.findAllBudget()

}