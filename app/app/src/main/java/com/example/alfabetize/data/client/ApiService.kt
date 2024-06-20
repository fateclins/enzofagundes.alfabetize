package com.example.alfabetize.data.client

import com.example.alfabetize.models.Module
import com.example.alfabetize.models.User
import com.example.alfabetize.models.UserActivity
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @GET("api/modules")
    fun getModules(): Call<List<Module>>

    @POST("api/user-activities")
    fun postUserActivity(@Body activity: UserActivity): Call<Void>

    @POST("api/login")
    fun login(@Body user: User): Call<User>
}