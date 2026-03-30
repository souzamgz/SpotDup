package com.miguel.spotify.exception


import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationError(ex: MethodArgumentNotValidException): ResponseEntity<ValidationErrorResponse> {
        val messages = ex.bindingResult.fieldErrors.map { error ->
            error.defaultMessage ?: "Invalid value"
        }
        val response = ValidationErrorResponse(
            status = 400,
            error = "Validation failed",
            messages = messages
        )

        return ResponseEntity.badRequest().body(response)

    }
}