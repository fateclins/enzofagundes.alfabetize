package com.example.alfabetize.data.datasources.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.alfabetize.data.datasources.local.daos.ActivityDao
import com.example.alfabetize.data.datasources.local.daos.ActivityExercisesDao
import com.example.alfabetize.data.datasources.local.daos.ExerciseDao
import com.example.alfabetize.data.datasources.local.daos.ProfileDao
import com.example.alfabetize.data.datasources.local.daos.UserDao
import com.example.alfabetize.data.datasources.local.entities.Activity
import com.example.alfabetize.data.datasources.local.entities.ActivityExercises
import com.example.alfabetize.data.datasources.local.entities.Exercise
import com.example.alfabetize.data.datasources.local.entities.Module
import com.example.alfabetize.data.datasources.local.entities.Profile
import com.example.alfabetize.data.datasources.local.entities.User

@Database(entities = [
    User::class,
    Activity::class,
    Exercise::class,
    Module::class,
    Profile::class,
    ActivityExercises::class
],
version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun activityDao(): ActivityDao
    abstract fun exerciseDao(): ExerciseDao
    abstract fun profileDao(): ProfileDao
    abstract fun activityExercisesDao(): ActivityExercisesDao
}