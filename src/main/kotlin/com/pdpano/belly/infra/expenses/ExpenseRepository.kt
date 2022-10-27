package com.pdpano.belly.infra.expenses

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.time.LocalDateTime

interface ExpenseRepository: JpaRepository<ExpenseSchema, Long> {


    @Query("""
        select (count(t) > 0)
        from tb_expenses t
        where upper(t.description) = upper(?1) and t.createdAt between ?2 and ?3
    """)
    fun existsByDescriptionAndMonth(
        description: String,
        createdAtStart: LocalDateTime,
        createdAtEnd: LocalDateTime
    ): Boolean

}