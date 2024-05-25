package com.example.alfabetize.data.datasources.local.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.alfabetize.data.datasources.local.entities.ActivityExercises

@Dao
interface ActivityExercisesDao {
    @Query("SELECT * FROM activity_exercises")
    fun index(): List<ActivityExercises>

    @Query("SELECT * FROM activity_exercises WHERE exercise_id = :id")
    fun showByExercise(id: Int): List<ActivityExercises>

    @Query("SELECT * FROM activity_exercises WHERE activity_id = :id")
    fun showByActivity(id: Int): List<ActivityExercises>

    @Insert
    fun store(activityExercises: ActivityExercises)

    @Update
    fun update(activityExercises: ActivityExercises)

    @Delete
    fun destroy(activityExercises: ActivityExercises)
}