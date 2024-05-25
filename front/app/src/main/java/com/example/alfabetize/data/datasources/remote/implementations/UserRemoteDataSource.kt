package com.example.alfabetize.data.datasources.remote.implementations

import com.example.alfabetize.data.datasources.remote.RetrofitClient
import com.example.alfabetize.data.datasources.remote.api.ApiService
import com.example.alfabetize.data.datasources.remote.entities.User
import com.example.alfabetize.data.datasources.remote.interfaces.IUserRemoteDataSource
import retrofit2.Call

class UserRemoteDataSource : IUserRemoteDataSource {
    private val apiService: ApiService = RetrofitClient.apiService

    override suspend fun getAllUsers(): Call<List<User>> {
        val response = apiService.getUsers()
        return response
    }

    override suspend fun getUser(id: Int): Call<User> {
        val response = apiService.getUser(id)
        return response
    }

    override suspend fun insertUser(user: User): Call<User> {
        val response = apiService.createUser(user)
        return response
    }

    override suspend fun deleteUser(id: Int): Call<Void> {
        val response = apiService.deleteUser(id)
        return response
    }

    override suspend fun updateUser(id: Int, user: User): Call<User> {
        val response = apiService.updateUser(id, user)
        return response
    }

}