package com.example.taskbox.UI.Reminders


import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.taskbox.Adapters.RemindersListAdapter
import com.example.taskbox.R
import com.example.taskbox.databinding.FragmentAddReminderBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class AddReminderFragment : Fragment() {

    private var _binding: FragmentAddReminderBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: RemindersListAdapter
    private lateinit var viewModel: AddReminderViewModel
    private var startDateInMillis: Long? = null
    private var dueDateInMillis: Long? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAddReminderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize ViewModel
        viewModel = ViewModelProvider(this).get(AddReminderViewModel::class.java)

        binding.buttonSaveTask.setOnClickListener {
            val name = binding.editTextTaskName.text.toString()
            val details = binding.editTextNotes.text.toString()

            val calendar = Calendar.getInstance()
            val dueDate = calendar.timeInMillis
            val startDate = calendar.timeInMillis

            viewModel.addReminder(name, details, dueDate, startDate)
//            scheduleNotification(requireContext(), dueDate, name, details)
        }

        binding.editTextStartDate.setOnClickListener {
            showDatePickerDialog(it)
        }

        binding.editTextDueDate.setOnClickListener {
            showDatePickerDialog(it)
        }

    }


//    private fun scheduleNotification(context: Context, dueDateInMillis: Long, name: String, details: String) {
//        val intent = Intent(context, ReminderBroadcastReceiver::class.java).apply {
//            putExtra("title", name)
//            putExtra("details", details)
//        }
//        val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
//
//        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
//        alarmManager.setExact(AlarmManager.RTC_WAKEUP, dueDateInMillis, pendingIntent)
//    }
private fun showDatePickerDialog(view: View) {
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    DatePickerDialog(requireContext(), { _, selectedYear, selectedMonth, selectedDay ->
        calendar.set(selectedYear, selectedMonth, selectedDay, 0, 0, 0)
        val selectedDateInMillis = calendar.timeInMillis

        val formattedDate = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(calendar.time)

        when (view.id) {
            R.id.editTextStartDate -> {
                binding.editTextStartDate.setText(formattedDate)
                startDateInMillis = selectedDateInMillis
            }
            R.id.editTextDueDate -> {
                binding.editTextDueDate.setText(formattedDate)
                dueDateInMillis = selectedDateInMillis
            }
        }
    }, year, month, day).show()
}

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}