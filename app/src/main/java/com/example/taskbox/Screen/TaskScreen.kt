package com.example.taskbox.Screen

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.taskbox.Adapters.TaskListAdapter
import com.example.taskbox.Data.Task
import com.example.taskbox.DrawerSetup
import com.example.taskbox.R

class TaskScreen: AppCompatActivity() {

    private val tasks = ArrayList<Task>()
    private lateinit var adapter: TaskListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)

        val menuButton = findViewById<ImageView>(R.id.menuButton)
        menuButton.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)

        }

        DrawerSetup(R.id.nav_view, R.id.drawerLayout)

        adapter = TaskListAdapter(tasks)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val addButton =findViewById<Button>(R.id.addButton)
        val TaskEdit = findViewById<EditText>(R.id.editText)


        addButton.setOnClickListener {

            val taskName = TaskEdit.text.toString().trim()
            if (taskName.isNotEmpty()) {
                tasks.add(Task(taskName, false))
                adapter.notifyDataSetChanged()
                TaskEdit.text.clear()
            } else {
                Toast.makeText(this, "Please enter a task", Toast.LENGTH_SHORT).show()
            }
        }

        val clearButton = findViewById<Button>(R.id.clearButton)

        clearButton.setOnClickListener {
            val iterator = tasks.iterator()
            while (iterator.hasNext()) {
                val task = iterator.next()
                if (task.isChecked) {
                    iterator.remove()
                }
            }
            adapter.notifyDataSetChanged()
        }
    }
}
