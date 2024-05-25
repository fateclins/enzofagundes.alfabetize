package com.example.alfabetize.data.datasources.remote.entities

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class Profile(
    val id: Int,
    val name: String?,
    val username: String?,
    val literacyLevel: String?,
    val xp: Int?,
    val avatar: String?,
    val birthdate: String?,
    val userId: Int?
)