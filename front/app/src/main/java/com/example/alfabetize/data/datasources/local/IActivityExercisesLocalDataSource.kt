package com.example.alfabetize.data.datasources.local

import com.example.alfabetize.data.datasources.local.entities.ActivityExercises
import com.example.alfabetize.data.datasources.local.entities.Exercise

interface IActivityExercisesLocalDataSource {
    suspend fun getAllActivityExercises(): List<ActivityExercises>
    suspend fun getByActivityId(activityId: Int): List<ActivityExercises>
    suspend fun getByExerciseId(exerciseId: Int): List<ActivityExercises>
    suspend fun insert(activityExercises: ActivityExercises)
    suspend fun delete(activityExercises: ActivityExercises)
    suspend fun update(activityExercises: ActivityExercises)
}
