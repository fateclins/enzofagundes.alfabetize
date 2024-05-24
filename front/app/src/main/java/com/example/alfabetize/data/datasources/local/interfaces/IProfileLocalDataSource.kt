package com.example.alfabetize.data.datasources.local.interfaces

import com.example.alfabetize.data.datasources.local.entities.Profile

interface IProfileLocalDataSource {
    suspend fun getAllProfiles(): List<Profile>
    suspend fun getProfile(id: Int): Profile?
    suspend fun insertProfile(profile: Profile)
    suspend fun updateProfile(profile: Profile)
    suspend fun deleteProfile(profile: Profile)
    suspend fun getProfileByUserId(userId: Int): Profile?
}