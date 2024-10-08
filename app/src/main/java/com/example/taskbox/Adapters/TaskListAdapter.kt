package com.example.taskbox.Adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.example.taskbox.R
import com.example.taskbox.Data.ToDoList
import com.example.taskbox.UI.ToDoList.TaskViewModel

class TaskListAdapter(private var taskList: List<ToDoList>, private val viewModel: TaskViewModel) :
    RecyclerView.Adapter<TaskListAdapter.TaskViewHolder>() {

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val checkBox: CheckBox = itemView.findViewById(R.id.checkBox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.task_list_rec, parent, false)
        return TaskViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = taskList[position]
        holder.checkBox.text = task.name
        holder.checkBox.isChecked = task.isChecked
        holder.checkBox.setOnCheckedChangeListener { _, isChecked ->
            // Update the task's checked state
            task.isChecked = isChecked
            viewModel.updateTask(task)

        }
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    fun updateTasks(newTasks: List<ToDoList>) {
        taskList = newTasks
        notifyDataSetChanged()
    }
}

//
//class TaskListAdapter(private val taskList: ArrayList<Task>) :
//    RecyclerView.Adapter<TaskListAdapter.TaskViewHolder>() {
//
//    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val checkBox: CheckBox = itemView.findViewById(R.id.checkBox)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
//        val itemView = LayoutInflater.from(parent.context)
//            .inflate(R.layout.task_list_rec, parent, false)
//        return TaskViewHolder(itemView)
//    }
//
//    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
//        val task = taskList[position]
//        holder.checkBox.text = task.name
//        holder.checkBox.isChecked = task.isChecked
//        holder.checkBox.setOnCheckedChangeListener { _, isChecked ->
//            task.isChecked = isChecked
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return taskList.size
//    }
//    fun updateTasks(newTasks: ArrayList<Task>) {
//        taskList.clear()
//        taskList.addAll(newTasks)
//        notifyDataSetChanged()
//        }
//}
//
