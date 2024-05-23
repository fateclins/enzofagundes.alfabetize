package com.example.alfabetize.data.datasources.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "profiles",
    foreignKeys = [ForeignKey(
        entity = User::class,
        childColumns = ["user_id"],
        parentColumns = ["id"],
        onDelete = ForeignKey.CASCADE
    )]
)

data class Profile(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "username") val username: String?,
    @ColumnInfo(name = "literacy_level") val literacyLevel: String?,
    @ColumnInfo(name = "xp") val xp: Int?,
    @ColumnInfo(name = "avatar") val avatar: String?,
    @ColumnInfo(name = "birthdate") val birthdate: String?,
    @ColumnInfo(name = "user_id") val userId: Int?
)