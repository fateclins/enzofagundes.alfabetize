package com.example.alfabetize.data.datasources.remote.interfaces

import com.example.alfabetize.data.datasources.remote.api.ApiService
import com.example.alfabetize.data.datasources.remote.entities.Exercise
import retrofit2.Call

interface IExerciseRemoteDataSource {
    val apiService: ApiService
    suspend fun getAllExercises(): Call<List<Exercise>>
    suspend fun getExercise(id: Int): Call<Exercise>
    suspend fun insertExercise(exercise: Exercise): Call<Exercise>
    suspend fun updateExercise(id: Int, exercise: Exercise): Call<Exercise>
    suspend fun deleteExercise(id: Int): Call<Void>
}