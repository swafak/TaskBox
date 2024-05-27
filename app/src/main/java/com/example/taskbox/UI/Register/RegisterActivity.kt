package com.example.taskbox.UI.Login

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.taskbox.R
import com.example.taskbox.UI.Task.TaskScreenActivity
import com.google.android.material.button.MaterialButton


class RegisterActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        val startButton = findViewById<MaterialButton>(R.id.register_btn)
        startButton.setOnClickListener {
            val Intent = Intent (this, TaskScreenActivity::class.java)
            startActivity(Intent)
        }

    }

fun startLoginActivity(view: View) {
    val intent = Intent(this, LoginActivity::class.java)
    startActivity(intent)
    finish()
}
}








