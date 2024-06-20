package com.example.alfabetize.models

data class Module(
    val id: Int,
    val title: String,
    val description: String,
    val createdAt: String,
    val updatedAt: String,
    val activities: List<Activity>
)