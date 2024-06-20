package com.example.alfabetize.models

data class Activity(
    val id: Int,
    val module_id: Int,
    val title: String,
    val content: String,
    val type: String,
    val correct_answer: String,
    val createdAt: String,
    val updatedAt: String,
    val points: Int,
)