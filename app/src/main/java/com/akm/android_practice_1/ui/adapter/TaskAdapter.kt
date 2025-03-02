package com.akm.android_practice_1.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.akm.android_practice_1.R
import com.akm.android_practice_1.data.model.Task
import org.w3c.dom.Text

class TaskAdapter(private var tasks: List<Task>) :
    RecyclerView.Adapter<TaskAdapter.TaskViewHolder>(){
        //ViewHolder Class to hold the view
        class TaskViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            //Define UI elements
            val taskDescription: TextView = itemView.findViewById(R.id.task_desc)
            val taskDeadline: TextView = itemView.findViewById(R.id.task_deadline)

            //Function to bind data into view
            fun bind(task: Task){
                taskDescription.text = task.task_description
                taskDeadline.text = "${task.start_date} - ${task.end_date}"
            }
        }

        // Create new views (invoked by the layout manager)
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
            //inflate the layout for each item
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.task_layout, parent, false)

            return TaskViewHolder(view)
        }

        //return the size of dataset (Invoked by layout mananger)
        override fun getItemCount(): Int {
            return tasks.size
        }

        // Replace the contents of a view (invoked by the layout manager)
        override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
            //Get element from dataSet at this position and bind it to the view holder
            val task = tasks[position]
            holder.bind(task)
        }

        //Optional: Function to update the dataset
        fun updateTasks(newTasks: List<Task>): Int{
            tasks = newTasks
            notifyDataSetChanged()

            return tasks.size
        }
    }