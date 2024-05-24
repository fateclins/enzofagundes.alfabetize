package com.example.alfabetize.data.datasources.local.interfaces

import com.example.alfabetize.data.datasources.local.entities.Exercise

interface IExerciseLocalDataSource {
    suspend fun getAllExercises(): List<Exercise>
    suspend fun getExercise(id: Int): Exercise
    suspend fun insertExercise(exercise: Exercise)
    suspend fun updateExercise(exercise: Exercise)
    suspend fun deleteExercise(exercise: Exercise)
}