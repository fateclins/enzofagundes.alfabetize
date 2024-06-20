package com.example.alfabetize.data.datasources.remote.interfaces

import com.example.alfabetize.data.datasources.remote.api.ApiService
import com.example.alfabetize.data.datasources.remote.entities.Activity
import retrofit2.Call

interface IActivityRemoteDataSource {
    val apiService: ApiService
    suspend fun getAllActivities(): Call<List<Activity>>
    suspend fun insertActivity(activity: Activity): Call<Activity>
    suspend fun deleteActivity(id: Int): Call<Void>
    suspend fun updateActivity(id: Int, activity: Activity): Call<Activity>
    suspend fun getActivity(id: Int): Call<Activity>
}