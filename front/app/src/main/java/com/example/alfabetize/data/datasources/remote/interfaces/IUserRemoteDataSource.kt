package com.example.alfabetize.data.datasources.remote.interfaces

import com.example.alfabetize.data.datasources.remote.entities.User
import retrofit2.Call

interface IUserRemoteDataSource {
    suspend fun getAllUsers(): Call<List<User>>
    suspend fun getUser(id: Int): Call<User>
    suspend fun insertUser(user: User): Call<User>
    suspend fun deleteUser(id: Int): Call<Void>
    suspend fun updateUser(id: Int, user: User): Call<User>
}