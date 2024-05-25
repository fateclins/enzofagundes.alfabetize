package com.example.alfabetize.data.datasources.remote.interfaces

import com.example.alfabetize.data.datasources.remote.api.ApiService
import com.example.alfabetize.data.datasources.remote.entities.ActivityExercises
import retrofit2.Call

interface IActivityExercisesRemoteDataSource {
    val apiService: ApiService
    suspend fun getAllActivityExercises(): Call<List<ActivityExercises>>
    suspend fun getByActivityId(activityId: Int): Call<List<ActivityExercises>>
    suspend fun getByExerciseId(exerciseId: Int): Call<List<ActivityExercises>>
    suspend fun insert(activityExercises: ActivityExercises): Call<ActivityExercises>
    suspend fun delete(id: Int): Call<Void>
    suspend fun update(id: Int, activityExercises: ActivityExercises): Call<ActivityExercises>
}