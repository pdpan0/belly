package com.pdpano.belly.infra.incomes

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface IncomeRepository: JpaRepository<IncomeSchema, Long> {

    @Query(
        value = """
           select exists (
              select id_income 
              from tb_incomes 
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