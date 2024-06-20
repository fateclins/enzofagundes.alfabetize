package com.example.alfabetize.data.datasources.remote.implementations

import com.example.alfabetize.data.datasources.remote.RetrofitClient
import com.example.alfabetize.data.datasources.remote.api.ApiService
import com.example.alfabetize.data.datasources.remote.entities.Exercise
import com.example.alfabetize.data.datasources.remote.interfaces.IExerciseRemoteDataSource
import retrofit2.Call

class ExerciseRemoteDataSource : IExerciseRemoteDataSource {
    override val apiService: ApiService
        get() = RetrofitClient.apiService

    override suspend fun getAllExercises(): Call<List<Exercise>> = apiService.getExercises()

    override suspend fun getExercise(id: Int): Call<Exercise> = apiService.getExercise(id)

    override suspend fun insertExercise(exercise: Exercise): Call<Exercise> = apiService.createExercise(exercise)

    override suspend fun updateExercise(id: Int, exercise: Exercise): Call<Exercise> = apiService.updateExercise(id, exercise)

    override suspend fun deleteExercise(id: Int): Call<Void> = apiService.deleteExercise(id)
}