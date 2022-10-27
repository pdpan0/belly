package com.pdpano.belly.infra.incomes

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.time.LocalDateTime

interface IncomeRepository: JpaRepository<IncomeSchema, Long> {

    @Query("""
        select (count(t) > 0) 
        from tb_incomes t 
        where upper(t.description) = upper(?1) and t.createdAt between ?2 and ?3
    """)
    fun existsByDescriptionAndMonth(
        description: String,
        createdAtStart: LocalDateTime,
        createdAtEnd: LocalDateTime
    ): Boolean

}