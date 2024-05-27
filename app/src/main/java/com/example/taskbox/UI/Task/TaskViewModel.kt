package com.example.taskbox.UI.Task

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.taskbox.Data.Task

class TaskViewModel : ViewModel() {

    private val _tasks = MutableLiveData<ArrayList<Task>>()
    val tasks: LiveData<ArrayList<Task>> get() = _tasks

    init {
        _tasks.value = ArrayList()
    }

    fun addTask(taskName: String) {
        val currentTasks = _tasks.value ?: ArrayList()
        currentTasks.add(Task(taskName, false))
        _tasks.value = currentTasks
    }

    fun removeCheckedTasks() {
        val currentTasks = _tasks.value ?: return
        currentTasks.removeAll { it.isChecked }
        _tasks.value = currentTasks
    }
}
