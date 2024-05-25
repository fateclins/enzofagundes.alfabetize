package com.example.alfabetize.data.datasources.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName = "activity_exercises",
    primaryKeys = ["activity_id", "exercise_id"],
    foreignKeys = [
        ForeignKey(entity = Activity::class, parentColumns = ["id"], childColumns = ["activity_id"]),
        ForeignKey(entity = Exercise::class, parentColumns = ["id"], childColumns = ["exercise_id"])
    ]
)
data class ActivityExercises(
    @ColumnInfo(name = "activity_id") val activityId: Int,
    @ColumnInfo(name = "exercise_id") val exerciseId: Int
)
