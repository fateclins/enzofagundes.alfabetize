package com.example.alfabetize.data.datasources.local.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.alfabetize.data.datasources.local.entities.Exercise

@Dao
interface ExerciseDao {
    @Query("SELECT * FROM exercises")
    fun index(): List<Exercise>

    @Query("SELECT * FROM exercises WHERE id = :id")
    fun show(id: Int): Exercise

    @Insert
    fun store(exercise: Exercise)

    @Update
    fun update(exercise: Exercise)

    @Delete
    fun destroy(exercise: Exercise)
}