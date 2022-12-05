package com.pdpano.belly.adapters.ships

import com.pdpano.belly.adapters.configurations.ResponseMessage
import com.pdpano.belly.domain.expenses.Expense
import com.pdpano.belly.usecase.expenses.saveexpense.SaveExpenseInput
import com.pdpano.belly.usecase.expense.saveexpenseusecase.SaveExpenseUseCase
import com.pdpano.belly.usecase.expenses.getexpensebyid.GetExpenseByIdUseCase
import com.pdpano.belly.usecase.expenses.getexpenses.GetExpensesUseCase
import com.pdpano.belly.usecase.expenses.updateexpense.UpdateExpenseInput
import com.pdpano.belly.usecase.expenses.updateexpense.UpdateExpenseUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@Suppress("unused")
@RestController
@RequestMapping("/v1/expenses")
class ExpenseController(
    private val saveExpenseUseCase: SaveExpenseUseCase,
    private val getExpensesUseCase: GetExpensesUseCase,
    private val getExpenseByIdUseCase: GetExpenseByIdUseCase,
    private val updateExpenseUseCase: UpdateExpenseUseCase,
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

    @GetMapping("/{idExpense}")
    fun getExpenseById(@PathVariable("idExpense") idExpense: Long): ResponseEntity<ResponseMessage<Expense>> {
        return ResponseEntity.ok(
            ResponseMessage(success = true, response = getExpenseByIdUseCase.execute(idExpense))
        )
    }

    @PutMapping("/{idExpense}")
    fun updateExpense(@PathVariable("idExpense") idExpense: Long, request: UpdateExpenseInput): ResponseEntity<ResponseMessage<Nothing>> {
        updateExpenseUseCase.execute(input = request)
        return ResponseEntity.noContent().build()
    }


}