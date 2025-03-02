package com.akm.android_practice_1.data.repository

import android.util.Log
import com.akm.android_practice_1.data.api.ApiService
import com.akm.android_practice_1.data.model.Task
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TaskRepository {
    private val apiService: ApiService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://67c28b8b1851890165ac9c68.mockapi.io/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(ApiService::class.java)
    }

    suspend fun getTasks(): List<Task>? {
        val response = apiService.getTasks()
        Log.d("AKM", "API responsed" + response.body().toString())
        return if(response.isSuccessful) response.body() else null
    }
}