package com.example.taskbox


import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.taskbox.R.id.nav_host_fragment
import com.google.android.material.navigation.NavigationView

fun AppCompatActivity.DrawerSetup(navViewId: Int, drawerLayoutId: Int) {
    val drawerLayout: androidx.drawerlayout.widget.DrawerLayout = findViewById(drawerLayoutId)
    val navView: NavigationView = findViewById(navViewId)

    val navController = findNavController(nav_host_fragment)
    val appBarConfiguration = AppBarConfiguration(
        setOf(R.id.nav_todolist, R.id.nav_reminder), drawerLayout
    )

    // Setup ActionBar with NavigationUI
    NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
    NavigationUI.setupWithNavController(navView, navController)

    navView.setNavigationItemSelectedListener { menuItem ->
        navController.navigate(menuItem.itemId)
        drawerLayout.closeDrawer(GravityCompat.START)
        true
    }
}
//
//override fun onSupportNavigateUp(): Boolean {
//    val navController = findNavController(nav_host_fragment)
//    return navController.navigateUp() || super.onSupportNavigateUp()
//}
