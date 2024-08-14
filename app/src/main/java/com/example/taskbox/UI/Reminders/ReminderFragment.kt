package com.example.taskbox.UI.Reminders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskbox.Adapters.RemindersListAdapter
import com.example.taskbox.databinding.FragmentReminderBinding

class ReminderFragment : Fragment() {

    private lateinit var binding: FragmentReminderBinding
    private lateinit var viewModel: AddReminderViewModel
    private lateinit var adapter: RemindersListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentReminderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewModel = ViewModelProvider(this).get(AddReminderViewModel::class.java)
        adapter = RemindersListAdapter(emptyList())
          binding.recyclerView.adapter = adapter

        // Observe the reminders LiveData and update the RecyclerView when it changes
        viewModel.reminders.observe(viewLifecycleOwner) { reminders ->
            adapter.updateReminders(reminders)
        }
    }
}
