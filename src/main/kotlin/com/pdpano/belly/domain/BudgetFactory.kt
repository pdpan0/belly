package com.pdpano.belly.domain

interface BudgetFactory {
    fun save(budget: Budget): Long
    fun existsByDescriptionAndCurrentMonth(description: String): Boolean
    fun findAllBudget(): List<Budget>
    fun findBudgetById(idBudget: Long): Budget
    fun updateBudget(budget: Budget)
}