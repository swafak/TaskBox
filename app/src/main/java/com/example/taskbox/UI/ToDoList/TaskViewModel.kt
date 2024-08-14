package com.example.taskbox.UI.ToDoList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.taskbox.Data.RoomDB.TaskBoxDB
import com.example.taskbox.Data.RoomDB.ToDoListDao
import com.example.taskbox.Data.ToDoList
import kotlinx.coroutines.launch

class TaskViewModel(application: Application) : AndroidViewModel(application) {

    private val toDoListDao: ToDoListDao = TaskBoxDB.getDatabase(application).ToDoListDao()
    val tasks: LiveData<List<ToDoList>> = toDoListDao.getAllTasks()

    fun addTask(taskName: String) {
        viewModelScope.launch {
            toDoListDao.insert(ToDoList(name = taskName))
        }
    }


    fun removeCheckedTasks() {
        viewModelScope.launch {
            toDoListDao.deleteCheckedTasks()
        }
    }

    fun updateTask(task: ToDoList) {
        viewModelScope.launch {
            toDoListDao.update(task)

        }
    }
}

