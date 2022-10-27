package com.pdpano.belly.adapters.ships

import com.pdpano.belly.adapters.configurations.ResponseMessage
import com.pdpano.belly.domain.expenses.Expense
import com.pdpano.belly.usecase.expenses.saveexpenseusecase.SaveExpenseInput
import com.pdpano.belly.usecase.expense.saveexpenseusecase.SaveExpenseUseCase
import com.pdpano.belly.usecase.expenses.getexpensesusecase.GetExpensesUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@Suppress("unused")
@RestController
@RequestMapping("/v1/expenses")
class ExpenseController(
    private val saveExpenseUseCase: SaveExpenseUseCase,
    private val getExpensesUseCase: GetExpensesUseCase
) {

    @PostMapping
    fun saveExpense(@RequestBody input: SaveExpenseInput): ResponseEntity<ResponseMessage<Long>> {
        val idExpense = saveExpenseUseCase.execute(input)
        return ResponseEntity.created(URI("/v1/expenses/$idExpense")).body(
            ResponseMessage(success = true, response = idExpense)
        )
    }

    @GetMapping
    fun getExpenses(): ResponseEntity<List<Expense>> {
        return ResponseEntity.ok(getExpensesUseCase.execute(null))
    }
}