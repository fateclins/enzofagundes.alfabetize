package com.example.alfabetize.data.datasources.remote.implementations

import com.example.alfabetize.data.datasources.remote.RetrofitClient
import com.example.alfabetize.data.datasources.remote.api.ApiService
import com.example.alfabetize.data.datasources.remote.entities.Activity
import com.example.alfabetize.data.datasources.remote.interfaces.IActivityRemoteDataSource
import retrofit2.Call

class ActivityRemoteDataSource : IActivityRemoteDataSource {
    override val apiService: ApiService
        get() = RetrofitClient.apiService

    override suspend fun getAllActivities(): Call<List<Activity>> = apiService.getActivities()

    override suspend fun insertActivity(activity: Activity): Call<Activity> =
        apiService.createActivity(activity)

    override suspend fun deleteActivity(id: Int): Call<Void> = apiService.deleteActivity(id)

    override suspend fun updateActivity(id: Int, activity: Activity): Call<Activity> =
        apiService.updateActivity(id, activity)

    override suspend fun getActivity(id: Int): Call<Activity> = apiService.getActivity(id)

}