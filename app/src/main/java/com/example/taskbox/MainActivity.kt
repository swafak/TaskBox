package com.example.taskbox

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.example.taskbox.UI.Login.LoginActivity
import com.example.taskbox.Utils.SPLASH_DELAY
import com.example.taskbox.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        createNotificationChannel(this)

        binding.spinner.visibility = ProgressBar.VISIBLE

        Handler().postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_DELAY)
    }
}
//fun createNotificationChannel(context: Context) {
//    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//        val name = "ReminderChannel"
//        val descriptionText = "Channel for Alarm Reminders"
//        val importance = NotificationManager.IMPORTANCE_HIGH
//        val channel = NotificationChannel("reminder_channel", name, importance).apply {
//            description = descriptionText
//        }
//        val notificationManager: NotificationManager =
//            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//        notificationManager.createNotificationChannel(channel)
//    }
//}





