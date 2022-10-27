package com.pdpano.belly.adapters.ships

import com.pdpano.belly.adapters.configurations.ResponseMessage
import com.pdpano.belly.domain.incomes.Income
import com.pdpano.belly.usecase.incomes.getincomesusecase.GetIncomesUseCase
import com.pdpano.belly.usecase.incomes.saveincomeusecase.SaveIncomeInput
import com.pdpano.belly.usecase.incomes.saveincomeusecase.SaveIncomeUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@Suppress("unused")
@RestController
@RequestMapping("/v1/incomes")
class IncomeController(
    private val saveIncomeUseCase: SaveIncomeUseCase,
    private val getIncomesUseCase: GetIncomesUseCase,
) {

    @PostMapping
    fun saveIncome(@RequestBody input: SaveIncomeInput): ResponseEntity<ResponseMessage<Long>> {
        val idIncome = saveIncomeUseCase.execute(input)
        return ResponseEntity.created(URI("/v1/incomes/$idIncome")).body(
            ResponseMessage(success = true, response = idIncome)
        )
    }

    @GetMapping
    fun getIncomes(): ResponseEntity<List<Income>> {
        return ResponseEntity.ok(getIncomesUseCase.execute(null))
    }
}