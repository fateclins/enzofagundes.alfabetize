package com.example.alfabetize.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.alfabetize.data.client.ApiClient
import com.example.alfabetize.models.Module
import com.example.alfabetize.models.UserActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserActivityViewModel : ViewModel() {
    private val apiService = ApiClient.apiService
    private val _userActivities = MutableLiveData<List<UserActivity>>()
    val userActivities: LiveData<List<UserActivity>> = _userActivities

    fun postUserActivity(userActivity: UserActivity) {
        apiService.postUserActivity(userActivity).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    Log.d("API Success", "User activity posted successfully")
                } else {
                    Log.e("API Error", "Failed to post user activity: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Log.e("Network Error", "Failed to post user activity", t)
            }
        })
    }
}