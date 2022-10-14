package com.pdpano.belly.adapters.ships

import com.pdpano.belly.usecase.expenses.saveexpenseusecase.SaveExpenseInput
import com.pdpano.belly.usecase.expense.saveexpenseusecase.SaveExpenseUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Suppress("unused")
@RestController
@RequestMapping("/v1/incomes")
class IncomeController(private val saveIncomeUseCase: SaveExpenseUseCase) {

    @PostMapping
    fun saveIncome(@RequestBody income: SaveExpenseInput): ResponseEntity<Long> {
        return ResponseEntity.ok(saveIncomeUseCase.execute(income))
    }
}