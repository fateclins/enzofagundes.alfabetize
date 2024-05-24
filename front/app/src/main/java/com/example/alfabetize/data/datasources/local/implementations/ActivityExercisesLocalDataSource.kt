package com.example.alfabetize.data.datasources.local.implementations

import com.example.alfabetize.data.datasources.local.daos.ActivityExercisesDao
import com.example.alfabetize.data.datasources.local.entities.ActivityExercises
import com.example.alfabetize.data.datasources.local.interfaces.IActivityExercisesLocalDataSource

class ActivityExercisesLocalDataSource(
    private val activityExercisesDao: ActivityExercisesDao
) : IActivityExercisesLocalDataSource {
    override suspend fun getAllActivityExercises(): List<ActivityExercises> {
        return activityExercisesDao.index()
    }

    override suspend fun getByActivityId(activityId: Int): List<ActivityExercises> {
        return activityExercisesDao.showByActivity(activityId)
    }

    override suspend fun getByExerciseId(exerciseId: Int): List<ActivityExercises> {
        return activityExercisesDao.showByExercise(exerciseId)
    }

    override suspend fun insert(activityExercises: ActivityExercises) {
        return activityExercisesDao.store(activityExercises)
    }

    override suspend fun delete(activityExercises: ActivityExercises) {
        return activityExercisesDao.destroy(activityExercises)
    }

    override suspend fun update(activityExercises: ActivityExercises) {
        return activityExercisesDao.update(activityExercises)
    }
}