package com.pdpano.belly.domain

interface BudgetFactory {
    fun save(budget: Budget): Long
}