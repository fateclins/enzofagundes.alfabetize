package com.example.alfabetize.data.datasources.local.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.alfabetize.data.datasources.local.entities.Activity

@Dao
interface ActivityDao {
    @Query("SELECT * FROM activities")
    fun index(): List<Activity>

    @Query("SELECT * FROM activities WHERE id = :id")
    fun show(id: Int): Activity

    @Insert
    fun store(activity: Activity)

    @Update
    fun update(activity: Activity)

    @Delete
    fun destroy(activity: Activity)

    @Query("SELECT * FROM activities WHERE module_id = :moduleId")
    fun showByModuleId(moduleId: Int): List<Activity>
}