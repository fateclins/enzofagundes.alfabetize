package com.example.alfabetize.data.datasources.local

import com.example.alfabetize.data.datasources.local.entities.Activity

interface IActivityLocalDataSource {
    suspend fun getAllActivities(): List<Activity>
    suspend fun insertActivity(activity: Activity)
    suspend fun deleteActivity(activity: Activity)
    suspend fun updateActivity(activity: Activity)
    suspend fun getActivity(id: Int): Activity
}