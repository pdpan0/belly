package com.pdpano.belly.usecase.incomes.getincomebyid

import com.pdpano.belly.domain.incomes.Income
import com.pdpano.belly.domain.incomes.IncomeGateway
import com.pdpano.belly.usecase.UseCase
import org.springframework.stereotype.Service

@Service
class GetIncomeByIdUseCase(private val gateway: IncomeGateway): UseCase<Long, Income> {
    override fun execute(input: Long): Income = gateway.findBudgetById(input)
}