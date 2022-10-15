package com.pdpano.belly.domain

interface BudgetFactory {
    fun save(budget: Budget): Long
    fun existsByDescriptionAndCurrentMonth(description: String): Boolean
    fun findAllBudget(): List<Budget>
}