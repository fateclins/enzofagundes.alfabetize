package com.example.alfabetize.models

data class User(
    val id: Int?,
    val name: String?,
    val email: String,
    val password: String?,
    val email_verified_at: String?,
    var score: Int?,
    var sequence: Int?
)
