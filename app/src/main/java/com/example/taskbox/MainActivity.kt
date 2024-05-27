package com.example.taskbox

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.example.taskbox.Adapters.TaskListAdapter
import com.example.taskbox.Data.Task
import com.example.taskbox.UI.Login.LoginActivity
import com.example.taskbox.Utils.SPLASH_DELAY


class MainActivity : AppCompatActivity() {

    private val tasks = ArrayList<Task>()
    private lateinit var adapter: TaskListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<ProgressBar>(R.id.spinner)
        spinner.visibility = ProgressBar.VISIBLE

        Handler().postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_DELAY)
    }
}




