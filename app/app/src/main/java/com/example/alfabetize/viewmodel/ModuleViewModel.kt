package com.example.alfabetize.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.alfabetize.data.client.ApiClient
import com.example.alfabetize.models.Module
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ModuleViewModel : ViewModel() {
    private val _modules = MutableLiveData<List<Module>>()
    val modules: LiveData<List<Module>> = _modules

    private val apiService = ApiClient.apiService

    fun fetchModules() {
        apiService.getModules().enqueue(object : Callback<List<Module>> {
            override fun onResponse(p0: Call<List<Module>>, p1: Response<List<Module>>) {
                if (p1.isSuccessful) {
                    _modules.postValue(p1.body())
                } else {
                    _modules.postValue(emptyList())
                }
            }

            override fun onFailure(p0: Call<List<Module>>, p1: Throwable) {
                _modules.postValue(emptyList())
            }
        })
    }
}