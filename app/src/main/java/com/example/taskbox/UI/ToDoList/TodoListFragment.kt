package com.example.taskbox.UI.ToDoList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskbox.Adapters.TaskListAdapter
import com.example.taskbox.databinding.FragmentTodoListBinding

class TodoListFragment : Fragment() {

    private lateinit var binding: FragmentTodoListBinding
    private lateinit var adapter: TaskListAdapter
    private lateinit var viewModel: TaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTodoListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        adapter = TaskListAdapter(emptyList(), viewModel)

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        binding.addButton.setOnClickListener {
            val taskName = binding.editText.text.toString().trim()
            if (taskName.isNotEmpty()) {
                viewModel.addTask(taskName)
                binding.editText.text?.clear()
                Toast.makeText(requireContext(), "Task added", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(requireContext(), "Please enter a task", Toast.LENGTH_SHORT).show()
            }
        }

        binding.clearButton.setOnClickListener {
            viewModel.removeCheckedTasks()
        }

        viewModel.tasks.observe(viewLifecycleOwner) { tasks ->
            adapter.updateTasks(tasks)
        }
    }
}

