package com.example.taskbox

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.taskbox.databinding.ActivityTaskBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class TaskActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navBottomView
        val drawerNavView: NavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_todolist, R.id.nav_reminder , R.id.nav_add_reminder
            ),
            binding.drawerLayout
        )

        // Set up the BottomNavigationView with NavController
        navView.setupWithNavController(navController)

        //drawer menu
        drawerNavView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_todolist -> {

                    navController.popBackStack(R.id.nav_todolist, false)
                    navController.navigate(R.id.nav_todolist)
                }
                R.id.nav_reminder -> {
                    navController.popBackStack(R.id.nav_reminder, false)
                    navController.navigate(R.id.nav_reminder)
                }
                R.id.nav_add_reminder -> {
                    navController.popBackStack(R.id.nav_add_reminder, false)
                    navController.navigate(R.id.nav_add_reminder)
                }
            }

            binding.drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

        binding.toolbar.menuButton.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
    }
}

