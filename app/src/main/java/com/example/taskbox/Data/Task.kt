package com.example.taskbox.Data

data class Task(
    val name: String,
    var isChecked: Boolean,


    )

data class Reminder (
    val name: String,
    val Details: String,
    val DueDate: String,

)