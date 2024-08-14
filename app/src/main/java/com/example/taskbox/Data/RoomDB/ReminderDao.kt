package com.example.taskbox.Data.RoomDB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.taskbox.Data.ReminderList

@Dao
interface ReminderDao {

        @Insert
        suspend fun insert(reminderList: ReminderList)

        @Update
        suspend fun update(reminderList: ReminderList)

        @Query("SELECT * FROM reminders")
        fun getAllReminders(): LiveData<List<ReminderList>>

}