package com.miguel.spotify.exception

data class ValidationErrorResponse(
    val status: Int,
    val error: String,
    val messages: List<String>
)