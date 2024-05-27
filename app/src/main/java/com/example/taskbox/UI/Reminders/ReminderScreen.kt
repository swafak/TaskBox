package com.example.taskbox.UI.Reminders

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.taskbox.Adapters.RemindersListAdapter
import com.example.taskbox.Data.Reminder
import com.example.taskbox.DrawerSetup
import com.example.taskbox.R

class ReminderScreen: AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var RemAdapter: RemindersListAdapter
    private val list = ArrayList<Reminder>()
   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reminders)

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)

        val menuButton = findViewById<ImageView>(R.id.menuButton)
        menuButton.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)

        }
       DrawerSetup(R.id.nav_view, R.id.drawerLayout)

       val addButton = findViewById<Button>(R.id.addTask)

       addButton.setOnClickListener{
           val intent = Intent(this, AddReminderScreen::class.java)
           startActivity(intent)

       }

       recyclerView = findViewById(R.id.recyclerView)
       recyclerView.layoutManager = LinearLayoutManager(this)
       RemAdapter = RemindersListAdapter(list)
       recyclerView.adapter = RemAdapter



   }
}
