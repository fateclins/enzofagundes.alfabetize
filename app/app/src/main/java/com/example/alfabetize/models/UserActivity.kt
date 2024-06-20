package com.example.alfabetize.models

data class UserActivity(
    val user_id: Int,
    val activity_id: Int,
    val answer: String,
    val is_correct: Boolean,
    val is_completed: Boolean,
)
