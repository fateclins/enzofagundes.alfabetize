package com.example.alfabetize.data.datasources.local.entities

import android.service.voice.VoiceInteractionSession.ActivityId
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "activities",
    foreignKeys = [
        ForeignKey(
            entity = Module::class,
            parentColumns = ["id"],
            childColumns = ["module"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)

data class Activity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "module_id") val moduleId: Int
)