package com.akm.android_practice_1.ui.main

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.util.Calendar

class DatePickerFragment: DialogFragment(), DatePickerDialog.OnDateSetListener {

    private lateinit var requestKey: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestKey = arguments?.getString("requestKey") ?: "dateTimeResult"
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(requireActivity(), this, year, month, day)
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {

        val formattedDate = String.format("%02d/%02d/%d", dayOfMonth, month + 1, year)

        // Show TimePicker and listen for its result
        val timePicker = TimePickerFragment.newInstance(requestKey)
        val bundle = Bundle().apply {
            //put the selected date in selectedDate key of bundle
            putString("selectedDate", formattedDate)
            putString("requestKey", requestKey)
        }

        timePicker.arguments = bundle
        timePicker.show(parentFragmentManager, "timePicker")

    }

    companion object {
        fun newInstance(requestKey: String): DatePickerFragment {

            return DatePickerFragment().apply {
                arguments = Bundle().apply {
                    putString("requestKey", requestKey)
                }
            }

        }
    }
}