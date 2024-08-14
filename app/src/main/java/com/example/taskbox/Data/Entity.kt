package com.example.taskbox.Data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class ToDoList(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    var isChecked: Boolean = false
)

@Entity(tableName = "reminders")
data class ReminderList(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val details : String,
    val DueDate: Long,
    val startDate: Long

)