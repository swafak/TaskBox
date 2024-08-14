package com.example.taskbox.Data.RoomDB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.taskbox.Data.ToDoList

@Dao
interface ToDoListDao{
    @Insert
    suspend fun insert(doList: ToDoList)

    @Update
    suspend fun update(doList: ToDoList)

    @Query("DELETE FROM tasks WHERE isChecked = 1")
    suspend fun deleteCheckedTasks()

    @Query("SELECT * FROM tasks")
    fun getAllTasks(): LiveData<List<ToDoList>>
}

