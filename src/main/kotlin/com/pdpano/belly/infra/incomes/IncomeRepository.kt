package com.pdpano.belly.infra.incomes

import org.springframework.data.jpa.repository.JpaRepository

interface IncomeRepository: JpaRepository<IncomeSchema, Long>