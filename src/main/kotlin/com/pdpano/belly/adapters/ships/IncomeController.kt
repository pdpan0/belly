package com.pdpano.belly.adapters.ships

import com.pdpano.belly.adapters.configurations.ResponseMessage
import com.pdpano.belly.domain.incomes.Income
import com.pdpano.belly.usecase.expenses.updateexpense.UpdateExpenseInput
import com.pdpano.belly.usecase.incomes.getincomebyid.GetIncomeByIdUseCase
import com.pdpano.belly.usecase.incomes.getincomes.GetIncomesUseCase
import com.pdpano.belly.usecase.incomes.saveincome.SaveIncomeInput
import com.pdpano.belly.usecase.incomes.saveincome.SaveIncomeUseCase
import com.pdpano.belly.usecase.incomes.updateincome.UpdateIncomeInput
import com.pdpano.belly.usecase.incomes.updateincome.UpdateIncomeUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@Suppress("unused")
@RestController
@RequestMapping("/v1/incomes")
class IncomeController(
    private val saveIncomeUseCase: SaveIncomeUseCase,
    private val getIncomesUseCase: GetIncomesUseCase,
    private val getIncomeByIdUseCase: GetIncomeByIdUseCase,
    private val updateIncomeUseCase: UpdateIncomeUseCase,
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

    @GetMapping("/{idIncome}")
    fun getIncomeById(@PathVariable("idIncome") idIncome: Long): ResponseEntity<Income> {
        return ResponseEntity.ok(getIncomeByIdUseCase.execute(idIncome))
    }

    @PutMapping("/{idIncome}")
    fun updateExpense(@PathVariable("idIncome") idIncome: Long, request: UpdateIncomeInput): ResponseEntity<ResponseMessage<Nothing>> {
        updateIncomeUseCase.execute(input = request)
        return ResponseEntity.noContent().build()
    }
}