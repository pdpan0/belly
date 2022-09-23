package com.pdpano.belly.usecase

interface UseCase<I, O> {
    fun execute(input: I): O
}