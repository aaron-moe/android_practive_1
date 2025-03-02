package com.akm.android_practice_1.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akm.android_practice_1.data.model.Task
import com.akm.android_practice_1.data.repository.TaskRepository
import kotlinx.coroutines.launch

class TaskViewModel : ViewModel() {
    private val repository = TaskRepository()
    private val _tasks = MutableLiveData<List<Task>>()
    val tasks : LiveData<List<Task>> = _tasks

    fun fetchTasks(){
        viewModelScope.launch {
            try{
                val taskList = repository.getTasks()
                taskList?.let{
                    _tasks.postValue(it)
                }
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}