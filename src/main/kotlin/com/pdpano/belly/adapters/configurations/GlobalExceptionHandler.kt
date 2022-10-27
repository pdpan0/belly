package com.pdpano.belly.adapters.configurations

import com.pdpano.belly.domain.NotFoundException
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@Suppress("unused")
@RestControllerAdvice
class GlobalExceptionHandler {
    private val logger = KotlinLogging.logger {}

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleException(req: HttpServletRequest, e: Exception): ResponseErrorMessage =
        ResponseErrorMessage(false, e.cause.toString(), e.message, null)

    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleIllegalArgumentException(req: HttpServletRequest, e: IllegalArgumentException) =
        ResponseErrorMessage(false, e.cause.toString(), e.message, null)

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFoundException(req: HttpServletRequest, e: NotFoundException): ResponseErrorMessage =
        ResponseErrorMessage(false, e.cause.toString(), e.message, null)
    
}