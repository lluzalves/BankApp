package com.daniel.domain.dto

import java.io.Serializable

data class Statement(
    val title: String,
    val description: String,
    val date: String,
    val value: Double
) : Serializable