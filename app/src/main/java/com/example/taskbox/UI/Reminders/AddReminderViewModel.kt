package com.example.taskbox.UI.Reminders

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.taskbox.Data.ReminderList
import com.example.taskbox.Data.RoomDB.ReminderDao
import com.example.taskbox.Data.RoomDB.TaskBoxDB
import kotlinx.coroutines.launch

class AddReminderViewModel(application: Application) : AndroidViewModel(application) {

    private val reminderDao: ReminderDao = TaskBoxDB.getDatabase(application).ReminderDao()
    val reminders: LiveData<List<ReminderList>> = reminderDao.getAllReminders()

    fun addReminder(name: String, details: String, dueDate: Long, startDate: Long) {
        viewModelScope.launch {
            val reminder = ReminderList(name = name, details = details, DueDate = dueDate, startDate = startDate)
            reminderDao.insert(reminder)
        }
    }

    fun updateTask(task: ReminderList) {
        viewModelScope.launch {
            reminderDao.update(task)
        }
    }
}
