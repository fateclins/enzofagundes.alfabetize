package com.example.alfabetize.data.datasources.local.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.alfabetize.data.datasources.local.entities.Profile

@Dao
interface ProfileDao {
    @Query("SELECT * FROM profiles")
    fun index(): List<Profile>

    @Query("SELECT * FROM profiles WHERE id = :id")
    fun show(id: Int): Profile

    @Query("SELECT * FROM profiles WHERE user_id = :userId")
    fun findByUserId(userId: Int): Profile

    @Insert
    fun store(profile: Profile)

    @Update
    fun update(profile: Profile)

    @Delete
    fun destroy(profile: Profile)
}