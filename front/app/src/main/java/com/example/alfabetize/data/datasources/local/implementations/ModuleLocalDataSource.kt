package com.example.alfabetize.data.datasources.local.implementations

import com.example.alfabetize.data.datasources.local.daos.ModuleDao
import com.example.alfabetize.data.datasources.local.entities.Module
import com.example.alfabetize.data.datasources.local.interfaces.IModuleLocalDataSource

class ModuleLocalDataSource(
    private val moduleDao: ModuleDao
) : IModuleLocalDataSource {
    override suspend fun getAllModules(): List<Module> = moduleDao.index()

    override suspend fun getModule(id: Int): Module? = moduleDao.show(id)

    override suspend fun insertModule(module: Module) = moduleDao.store(module)

    override suspend fun updateModule(module: Module) = moduleDao.update(module)

    override suspend fun deleteModule(module: Module) = moduleDao.destroy(module)

}