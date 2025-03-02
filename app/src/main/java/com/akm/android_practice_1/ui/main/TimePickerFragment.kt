package com.akm.android_practice_1.ui.main

import android.annotation.SuppressLint
import android.app.Dialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment

class TimePickerFragment : DialogFragment(), TimePickerDialog.OnTimeSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        return TimePickerDialog(
            requireActivity(),
            this,
            hour,
            minute,
            DateFormat.is24HourFormat(requireContext())
        )
    }

    @SuppressLint("DefaultLocale")
    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        val formattedTime = String.format("%02d:%02d", hourOfDay, minute)
        val requestKey = arguments?.getString("requestKey") ?: return

        val selectedDate = arguments?.getString("selectedDate") ?: ""

        val dateTime = if(selectedDate.isNotEmpty()) "$selectedDate $formattedTime" else formattedTime

        val result = Bundle().apply {
            putString("selectedDateTime", dateTime)
        }
        parentFragmentManager.setFragmentResult(requestKey, result)

    }

    companion object {
        fun newInstance(requestKey: String): TimePickerFragment {
            Log.d("TimePicker", "newInstance start: requestKey - $requestKey")
            return TimePickerFragment().apply {
                arguments = Bundle().apply {
                    putString("requestKey", requestKey)
                }
            }
        }
    }
}