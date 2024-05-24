package com.example.alfabetize.data.datasources.local.implementations

import com.example.alfabetize.data.datasources.local.daos.ExerciseDao
import com.example.alfabetize.data.datasources.local.entities.Exercise
import com.example.alfabetize.data.datasources.local.interfaces.IExerciseLocalDataSource

class ExerciseLocalDataSource(
    private val exerciseDao: ExerciseDao
) : IExerciseLocalDataSource {
    override suspend fun getAllExercises(): List<Exercise> = exerciseDao.index()

    override suspend fun getExercise(id: Int): Exercise = exerciseDao.show(id)

    override suspend fun insertExercise(exercise: Exercise) = exerciseDao.store(exercise)

    override suspend fun updateExercise(exercise: Exercise) = exerciseDao.update(exercise)

    override suspend fun deleteExercise(exercise: Exercise) = exerciseDao.destroy(exercise)

}