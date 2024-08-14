package com.example.taskbox.UI.Register

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.taskbox.R
import com.example.taskbox.UI.Login.LoginActivity

import com.google.android.material.button.MaterialButton


class RegisterActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        val startButton = findViewById<MaterialButton>(R.id.register_btn)
        startButton.setOnClickListener {
            val Intent = Intent (this, LoginActivity::class.java)
            startActivity(Intent)
        }

    }

fun startLoginActivity(view: View) {
    val intent = Intent(this, LoginActivity::class.java)
    startActivity(intent)
    finish()
}
}








