package com.akm.android_practice_1.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.akm.android_practice_1.data.model.DataClass
import com.akm.android_practice_1.R

class AdapterClass(private val dataList: ArrayList<DataClass>): RecyclerView.Adapter<AdapterClass.ViewHolderClass>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.task_layout, parent, false)
        return ViewHolderClass(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentTaskDesc = dataList[position].taskDesc.toString()
        val currentTaskDeadline = dataList[position].TaskDeadline.toString()
        holder.taskDesc.text = currentTaskDesc
        holder.taskDeadline.text = currentTaskDeadline
    }


    class ViewHolderClass(itemView: View): RecyclerView.ViewHolder(itemView) {
        val taskDesc:TextView = itemView.findViewById(R.id.task_desc)
        val taskDeadline:TextView = itemView.findViewById(R.id.task_deadline)
    }


}