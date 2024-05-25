package com.example.alfabetize.data.datasources.local.interfaces

import com.example.alfabetize.data.datasources.local.entities.User

interface IUserLocalDataSource {
    suspend fun getAllUsers(): List<User>
    suspend fun insertUser(user: User)
    suspend fun deleteUser(user: User)
    suspend fun updateUser(user: User)
    suspend fun getUser(id: Int): User
}