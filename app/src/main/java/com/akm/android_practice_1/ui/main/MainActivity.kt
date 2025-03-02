package com.akm.android_practice_1.ui.main

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akm.android_practice_1.R
import com.akm.android_practice_1.databinding.ActivityMainBinding
import com.akm.android_practice_1.ui.adapter.TaskAdapter


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    //private var isStartDateTime = true //Flag to determine which textview to update


//    private lateinit var dataList: ArrayList<DataClass>
//    lateinit var taskDescList:Array<String>
//    lateinit var taskDeadlineList:Array<String>

    //variable for recyclerView
    private lateinit var taskRecyclerView: RecyclerView
    //For ViewModel & API data
    private lateinit var viewModel: TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnEditTask.setOnClickListener {
            val modalBtnSheet = ModalBottomSheet()
            modalBtnSheet.show(supportFragmentManager, "Showing Modal Sheet!")
        }

        // Click listener for start_date_time
        binding.startDateTime.setOnClickListener {

            // create new instance for DatePickerFragment as "startDateTimeResult"
            // selected date will be carried with "startDateTimeResult"
            val datePicker = DatePickerFragment.newInstance("startDateTimeResult")

            // show the instance which is stored "DatePickerFragment"
            datePicker.show(supportFragmentManager, "datePickerStart")
        }

        // Click listener for end_date_time
        binding.endDateTime.setOnClickListener {
            //isStartDateTime = false
            val datePicker = DatePickerFragment.newInstance("endDateTimeResult")
            datePicker.show(supportFragmentManager, "datePickerEnd")
        }

        //Setup listener for results (moved outside of click listeners)
        supportFragmentManager.setFragmentResultListener("startDateTimeResult", this) { _, result ->
            val dateTime = result.getString("selectedDateTime") ?: ""
            binding.startDateTime.text = dateTime
            Toast.makeText(this, "Start: $dateTime", Toast.LENGTH_SHORT).show()
        }


        supportFragmentManager.setFragmentResultListener("endDateTimeResult", this) { _, result ->
            val dateTime = result.getString("selectedDateTime") ?: ""
            binding.endDateTime.text = dateTime
            Toast.makeText(this, "End: $dateTime", Toast.LENGTH_SHORT).show()
        }

        //Creating array for tasklist
//        taskDescList = arrayOf(
//            "Read and Analyze the project brief",
//            "Identify all relevant stakeholders",
//            "Set timeline and milestone",
//            "Special dinner",
//            "Taking casual leave coz of Headache"
//        )

//        taskDeadlineList = arrayOf(
//            "Oct-16, 8:30 PM",
//            "Oct-8, 8:30 PM",
//            "Oct-18, 8:30 PM",
//            "Oct-20, 9:00 PM",
//            "Oct-21, 9:00 AM"
//        )

        taskRecyclerView = findViewById(R.id.task_recycler)
        taskRecyclerView.layoutManager = LinearLayoutManager(this)
        taskRecyclerView.setHasFixedSize(true)

        //Define dataList as type of DataClass
//        dataList = arrayListOf<DataClass>()

        //Show the RecyclerView
//        getData()

        //Show api data
        viewModel = ViewModelProvider(this)[TaskViewModel::class.java]
        Log.d("AKM", "Conpleted creating viewModel")
        viewModel.tasks.observe(this){ tasks ->
            tasks?.let{
                taskRecyclerView.adapter = TaskAdapter(it)
            }
        }

        viewModel.fetchTasks()
    }

    //Task RecyclerView implementation
//    private fun getData(){
//        for(i in taskDescList.indices){
//            val dataClass = DataClass(taskDescList[i], taskDeadlineList[i])
//            dataList.add(dataClass)
//        }
//        taskRecyclerView.adapter = AdapterClass(dataList)
//    }
}

