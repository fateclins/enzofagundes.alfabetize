package com.example.alfabetize.data.datasources.remote.implementations

import com.example.alfabetize.data.datasources.remote.RetrofitClient
import com.example.alfabetize.data.datasources.remote.api.ApiService
import com.example.alfabetize.data.datasources.remote.entities.Module
import com.example.alfabetize.data.datasources.remote.interfaces.IModuleRemoteDataSource
import retrofit2.Call

class ModuleRemoteDataSource : IModuleRemoteDataSource{
    override val apiService: ApiService
        get() = RetrofitClient.apiService

    override suspend fun getAllModules(): Call<List<Module>> = apiService.getModules()

    override suspend fun getModule(id: Int): Call<Module> = apiService.getModule(id)

    override suspend fun insertModule(module: Module): Call<Module> = apiService.createModule(module)

    override suspend fun deleteModule(id: Int): Call<Void> = apiService.deleteModule(id)

    override suspend fun updateModule(id: Int, module: Module): Call<Module> = apiService.updateModule(id, module)
}