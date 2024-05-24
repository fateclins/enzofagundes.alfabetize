package com.example.alfabetize.data.datasources.remote.api

import com.example.alfabetize.data.datasources.remote.entities.Activity
import com.example.alfabetize.data.datasources.remote.entities.Exercise
import com.example.alfabetize.data.datasources.remote.entities.Module
import com.example.alfabetize.data.datasources.remote.entities.Profile
import com.example.alfabetize.data.datasources.remote.entities.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {
    // user endpoints
    @GET("api/users")
    fun getUsers(): Call<List<User>>

    @GET("api/users/{id}")
    fun getUser(@Path("id") id: Int): Call<User>

    @POST("api/users")
    fun createUser(@Body user: User): Call<User>

    @PUT("api/users/{id}")
    fun updateUser(@Path("id") id: Int, @Body user: User): Call<User>

    @DELETE("api/users/{id}")
    fun deleteUser(@Path("id") id: Int): Call<Void>

    // profile endpoints
    @GET("api/profiles")
    fun getProfiles(): Call<List<Profile>>

    @GET("api/profiles/{id}")
    fun getProfile(@Path("id") id: Int): Call<Profile>

    @POST("api/profiles")
    fun createProfile(@Body profile: Profile): Call<Profile>

    @PUT("api/profiles/{id}")
    fun updateProfile(@Path("id") id: Int, @Body profile: Profile): Call<Profile>


    @DELETE("api/profiles/{id}")
    fun deleteProfile(@Path("id") id: Int): Call<Void>

    // modules endpoints

    @GET("api/modules")
    fun getModules(): Call<List<Module>>

    @GET("api/modules/{id}")
    fun getModule(@Path("id") id: Int): Call<Module>

    @POST("api/modules")
    fun createModule(@Body module: Module): Call<Module>

    @PUT("api/modules/{id}")
    fun updateModule(@Path("id") id: Int, @Body module: Module): Call<Module>

    @DELETE("api/modules/{id}")
    fun deleteModule(@Path("id") id: Int): Call<Void>

    // exercises endpoints

    @GET("api/exercises")
    fun getExercises(): Call<List<Exercise>>

    @GET("api/exercises/{id}")
    fun getExercise(@Path("id") id: Int): Call<Exercise>

    @POST("api/exercises")
    fun createExercise(@Body exercise: Exercise): Call<Exercise>

    @PUT("api/exercises/{id}")
    fun updateExercise(@Path("id") id: Int, @Body exercise: Exercise): Call<Exercise>

    @DELETE("api/exercises/{id}")
    fun deleteExercise(@Path("id") id: Int): Call<Void>

    // activities endpoints

    @GET("api/activities")
    fun getActivities(): Call<List<Activity>>

    @GET("api/activities/{id}")
    fun getActivity(@Path("id") id: Int): Call<Activity>

    @POST("api/activities")
    fun createActivity(@Body activity: Activity): Call<Activity>

    @PUT("api/activities/{id}")
    fun updateActivity(@Path("id") id: Int, @Body activity: Activity): Call<Activity>

    @DELETE("api/activities/{id}")
    fun deleteActivity(@Path("id") id: Int): Call<Void>
}