package com.miguel.spotify.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive

data class MusicRequest(

    @NotBlank
    val title: String,
    @NotBlank
    val artist: String,
    @Positive
    val durationMs: Long
)




