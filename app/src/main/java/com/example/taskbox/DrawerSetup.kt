package com.example.taskbox

import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.taskbox.Screen.ReminderScreen
import com.example.taskbox.Screen.TaskScreen
import com.google.android.material.navigation.NavigationView

fun AppCompatActivity.DrawerSetup(navViewId: Int, drawerLayoutId: Int) {
    val drawerLayout: androidx.drawerlayout.widget.DrawerLayout = findViewById(drawerLayoutId)
    val navView: NavigationView = findViewById(navViewId)

    val toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
    drawerLayout.addDrawerListener(toggle)
    toggle.syncState()

    supportActionBar?.setDisplayHomeAsUpEnabled(true)

    navView.setNavigationItemSelectedListener { menuItem ->
        when (menuItem.itemId) {
            R.id.nav_todolist -> startActivity(Intent(this, TaskScreen::class.java))
            R.id.nav_reminder -> startActivity(Intent(this, ReminderScreen::class.java))



        }
        drawerLayout.closeDrawer(GravityCompat.START)
        true
    }
}
fun AppCompatActivity.showToast(message: String) {
    Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
}
