package com.example.alfabetize.data.datasources.local.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.alfabetize.data.datasources.local.entities.User

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun index(): List<User>

    @Query("SELECT * FROM users WHERE id = :id")
    fun show(id: Int): User

    @Insert
    fun store(user: User)

    @Update
    fun update(user: User)

    @Delete
    fun destroy(user: User)
}