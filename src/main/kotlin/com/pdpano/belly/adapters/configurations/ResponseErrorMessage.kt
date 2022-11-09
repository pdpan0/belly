package com.pdpano.belly.adapters.configurations

data class ResponseErrorMessage(
    val success: Boolean,
    val type: String,
    val message: String?,
    val objectId: String?,
)