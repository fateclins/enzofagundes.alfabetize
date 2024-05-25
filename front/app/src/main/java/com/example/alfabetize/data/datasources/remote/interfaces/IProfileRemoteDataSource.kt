package com.example.alfabetize.data.datasources.remote.interfaces

import com.example.alfabetize.data.datasources.remote.entities.Profile
import retrofit2.Call

interface IProfileRemoteDataSource {
    suspend fun getAllProfiles(): Call<List<Profile>>
    suspend fun getProfile(id: Int): Call<Profile>
    suspend fun insertProfile(user: Profile): Call<Profile>
    suspend fun deleteProfile(id: Int): Call<Void>
    suspend fun updateProfile(id: Int, user: Profile): Call<Profile>
}