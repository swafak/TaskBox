package com.example.taskbox.UI.Reminders

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.taskbox.DrawerSetup
import com.example.taskbox.R

class AddReminderScreen: AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_task)

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)

        val menuButton = findViewById<ImageView>(R.id.menuButton)
        menuButton.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)

        }
        DrawerSetup(R.id.nav_view, R.id.drawerLayout)
    }
}
