package com.example.alfabetize.data.datasources.remote.implementations

import com.example.alfabetize.data.datasources.remote.RetrofitClient
import com.example.alfabetize.data.datasources.remote.api.ApiService
import com.example.alfabetize.data.datasources.remote.entities.Profile
import com.example.alfabetize.data.datasources.remote.interfaces.IProfileRemoteDataSource
import retrofit2.Call

class ProfileRemoteDataSource : IProfileRemoteDataSource {
    override val apiService: ApiService
        get() = RetrofitClient.apiService

    override suspend fun getAllProfiles(): Call<List<Profile>> = apiService.getProfiles()

    override suspend fun getProfile(id: Int): Call<Profile> = apiService.getProfile(id)

    override suspend fun insertProfile(profile: Profile): Call<Profile> = apiService.createProfile(profile)

    override suspend fun deleteProfile(id: Int): Call<Void> = apiService.deleteProfile(id)

    override suspend fun updateProfile(id: Int, user: Profile): Call<Profile> = apiService.updateProfile(id, user)
}