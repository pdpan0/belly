package com.pdpano.belly.infra.expenses

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface ExpenseRepository: JpaRepository<ExpenseSchema, Long> {

    @Query(
        value = """
           select exists (
              select id_expense 
              from tb_expenses 
              where description = ?1 
              and created_at 
                 between date_trunc('month', now())::date 
                 and (date_trunc('month', now()) + interval '1 month - 1 day')::date 
           ) 
        """,
        nativeQuery = true
    )
    fun existsByDescriptionAndCurrentMonth(description: String): Boolean
}