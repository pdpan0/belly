package com.pdpano.belly.adapters.configurations

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@Suppress("unused")
@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleException(req: HttpServletRequest, e: Exception): ResponseMessage =
        ResponseMessage(false, e.cause.toString(), e.message, null)
}