package com.example.taskbox.Adapters
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taskbox.Data.ReminderList
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class RemindersListAdapter(private var taskList: List<ReminderList>) :
        RecyclerView.Adapter<RemindersListAdapter.TaskViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
            val itemView = LayoutInflater.from(parent.context)
                .inflate(com.example.taskbox.R.layout.remi_list_rec,
                    parent,
                    false)
            return TaskViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
            val task = taskList[position]
            holder.textViewTaskName.text = "Name: ${task.name}"
            holder.textViewDetails.text = "Details: ${task.details}"


            // Convert milliseconds to date string
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            val startDateString = sdf.format(Date(task.startDate))
            val dueDateString = sdf.format(Date(task.DueDate))

           holder.textViewStartDate.text = "Start Date: $startDateString"
            holder.textViewDueDate.text = "Due Date: $dueDateString"
        }

        override fun getItemCount(): Int {
            return taskList.size
        }

    fun updateReminders(newReminders: List<ReminderList>) {
        taskList = newReminders
        notifyDataSetChanged()
    }

        class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val textViewTaskName: TextView = itemView.findViewById(com.example.taskbox.R.id.textViewTaskName)
            val textViewDueDate: TextView = itemView.findViewById(com.example.taskbox.R.id.textViewDueDate)
            val textViewDetails: TextView = itemView.findViewById(com.example.taskbox.R.id.textViewDetails)
            val textViewStartDate: TextView = itemView.findViewById(com.example.taskbox.R.id.textViewStartDate)
        }



    }
