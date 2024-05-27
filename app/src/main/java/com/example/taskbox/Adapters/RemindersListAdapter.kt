package com.example.taskbox.Adapters
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taskbox.Data.Reminder
import com.example.taskbox.Data.Task

    class RemindersListAdapter(private val taskList: List<Reminder>) :
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
            holder.textViewTaskName.text = task.name
            holder.textViewDueDate.text = task.DueDate
            holder.textViewDetails.text = task.Details
        }

        override fun getItemCount(): Int {
            return taskList.size
        }

        class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val textViewTaskName: TextView = itemView.findViewById(com.example.taskbox.R.id.textViewTaskName)
            val textViewDueDate: TextView = itemView.findViewById(com.example.taskbox.R.id.textViewDueDate)
            val textViewDetails: TextView = itemView.findViewById(com.example.taskbox.R.id.textViewDetails)
        }
    }
