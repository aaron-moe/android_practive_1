package com.akm.android_practice_1.data.model

data class Task(
    val id: Int,
    val task_description: String,
    val start_date: String,
    val end_date: String,
    val status: Boolean,
    val user_id: Int
)
