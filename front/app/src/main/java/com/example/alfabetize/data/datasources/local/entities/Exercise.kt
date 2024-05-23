package com.example.alfabetize.data.datasources.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercises")
data class Exercise(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "question") val question: String?,
    @ColumnInfo(name = "answer") val answer: String?
)
