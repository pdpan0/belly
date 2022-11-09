package com.pdpano.belly.adapters.configurations

data class ResponseMessage<T>(
    val success: Boolean = true,
    val response: T
)