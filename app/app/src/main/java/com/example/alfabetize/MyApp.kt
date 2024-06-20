package com.example.alfabetize

import android.app.Application
import com.example.alfabetize.models.User
import com.google.gson.Gson

class MyApp : Application() {
    var currentUser: User? = null

    companion object {
        private lateinit var instance: MyApp

        fun getInstance(): MyApp {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    fun setUserFromJson(userJson: String) {
        currentUser = Gson().fromJson(userJson, User::class.java)
    }

    fun getUserJson(): String? {
        return currentUser?.let { Gson().toJson(it) }
    }
}