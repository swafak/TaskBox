package com.example.taskbox.UI.Login

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.example.taskbox.R
import com.example.taskbox.UI.Task.TaskScreenActivity
import com.google.android.material.button.MaterialButton


class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val startButton = findViewById<MaterialButton>(R.id.login_btn)
        startButton.setOnClickListener {
            val Intent = Intent (this, TaskScreenActivity::class.java)
            startActivity(Intent)
        }

    }
}








