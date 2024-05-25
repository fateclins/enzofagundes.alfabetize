package com.example.alfabetize.data.datasources.local.interfaces

import com.example.alfabetize.data.datasources.local.entities.Module

interface IModuleLocalDataSource {
    suspend fun getAllModules(): List<Module>
    suspend fun getModule(id: Int): Module?
    suspend fun insertModule(module: Module)
    suspend fun updateModule(module: Module)
    suspend fun deleteModule(module: Module)

}