package com.example.alfabetize.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.alfabetize.data.client.ApiClient
import com.example.alfabetize.models.Module
import com.example.alfabetize.models.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {
    private val _user = MutableLiveData<User?>()
    val user: MutableLiveData<User?> = _user

    private val apiService = ApiClient.apiService

    fun login(user: User) {
        apiService.login(user).enqueue(object : Callback<User> {
            override fun onResponse(p0: Call<User>, p1: Response<User>) {
                if (p1.isSuccessful) {
                    _user.postValue(p1.body())
                } else {
                    Log.e("LoginViewModel", "Response unsuccessful: ${p1.errorBody()?.string()}")
                    _user.postValue(null)
                }
            }

            override fun onFailure(p0: Call<User>, p1: Throwable) {
                Log.e("LoginViewModel", "Request failed: ${p1.message}")
                _user.postValue(null)
            }
        })
    }
}