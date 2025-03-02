package com.akm.android_practice_1.data.api

import com.akm.android_practice_1.data.model.Task
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("tasks")
    suspend fun getTasks(): Response<List<Task>>
}