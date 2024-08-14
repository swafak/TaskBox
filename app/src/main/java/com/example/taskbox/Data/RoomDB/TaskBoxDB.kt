package com.example.taskbox.Data.RoomDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.taskbox.Data.ReminderList
import com.example.taskbox.Data.ToDoList

@Database(entities = [ToDoList::class, ReminderList::class], version = 1)
abstract class TaskBoxDB : RoomDatabase() {
    abstract fun ToDoListDao(): ToDoListDao
    abstract fun ReminderDao(): ReminderDao

    companion object {
        @Volatile
        private var INSTANCE: TaskBoxDB? = null

        fun getDatabase(context: Context): TaskBoxDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TaskBoxDB::class.java,
                    "TaskBox_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
