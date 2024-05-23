package com.example.alfabetize.data.datasources.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.alfabetize.data.datasources.local.daos.UserDao
import com.example.alfabetize.data.datasources.local.entities.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}