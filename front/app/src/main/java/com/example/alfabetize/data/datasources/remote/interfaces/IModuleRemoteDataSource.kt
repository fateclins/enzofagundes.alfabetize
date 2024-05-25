package com.example.alfabetize.data.datasources.remote.interfaces

import com.example.alfabetize.data.datasources.remote.api.ApiService
import com.example.alfabetize.data.datasources.remote.entities.Module
import retrofit2.Call

interface IModuleRemoteDataSource {
    val apiService: ApiService
    suspend fun getAllModules(): Call<List<Module>>
    suspend fun getModule(id: Int): Call<Module>
    suspend fun insertModule(module: Module): Call<Module>
    suspend fun deleteModule(id: Int): Call<Void>
    suspend fun updateModule(id: Int, module: Module): Call<Module>
}