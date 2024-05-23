package com.example.alfabetize.data.repositories

import com.example.alfabetize.data.datasources.local.UserLocalDataSource
import com.example.alfabetize.data.datasources.local.entities.User

class UserRepository(
    private val userLocalDataSource: UserLocalDataSource
) {
    suspend fun getAllUsers(): List<User> {
        return userLocalDataSource.getAllUsers()
    }

    suspend fun insertUser(user: User) {
        userLocalDataSource.insertUser(user)
    }

    suspend fun deleteUser(user: User) {
        userLocalDataSource.deleteUser(user)
    }

    suspend fun updateUser(user: User) {
        userLocalDataSource.updateUser(user)
    }

    suspend fun getUser(id: Int): User {
        return userLocalDataSource.getUser(id)
    }
}