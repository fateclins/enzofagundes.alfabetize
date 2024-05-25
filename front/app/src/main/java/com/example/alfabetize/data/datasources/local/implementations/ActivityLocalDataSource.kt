package com.example.alfabetize.data.datasources.local.implementations

import com.example.alfabetize.data.datasources.local.daos.ActivityDao
import com.example.alfabetize.data.datasources.local.entities.Activity
import com.example.alfabetize.data.datasources.local.interfaces.IActivityLocalDataSource

class ActivityLocalDataSource(
    private val activityDao: ActivityDao
) : IActivityLocalDataSource {
    override suspend fun getAllActivities(): List<Activity> = activityDao.index()

    override suspend fun insertActivity(activity: Activity) = activityDao.store(activity)

    override suspend fun deleteActivity(activity: Activity) = activityDao.destroy(activity)

    override suspend fun updateActivity(activity: Activity) = activityDao.update(activity)

    override suspend fun getActivity(id: Int): Activity = activityDao.show(id)
}