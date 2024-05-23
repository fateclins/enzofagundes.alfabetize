package com.example.alfabetize.data.datasources.local.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.alfabetize.data.datasources.local.entities.Module

@Dao
interface ModuleDao {
    @Query("SELECT * FROM modules")
    fun index(): List<Module>

    @Query("SELECT * FROM modules WHERE id = :id")
    fun show(id: Int): Module

    @Insert
    fun store(module: Module)

    @Update
    fun update(module: Module)

    @Delete
    fun destroy(module: Module)
}