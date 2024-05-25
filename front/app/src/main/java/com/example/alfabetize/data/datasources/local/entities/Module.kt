package com.example.alfabetize.data.datasources.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "modules")
data class Module(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo() val name: String
)
