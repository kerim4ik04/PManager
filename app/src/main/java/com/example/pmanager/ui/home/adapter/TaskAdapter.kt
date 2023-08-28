package com.example.pmanager.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.pmanager.databinding.ItemTaskBinding
import com.example.pmanager.model.Task

class TaskAdapter: Adapter<TaskAdapter.TaskViewHolder>() {

    private val list:ArrayList<Task> = arrayListOf()

    fun addTasks(task: List<Task>){
        list.clear()
        list.addAll(task)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(ItemTaskBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(list.get(position))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class TaskViewHolder(private val binding:ItemTaskBinding): ViewHolder(binding.root) {
        fun bind(task: Task) {
            binding.tvTitle.text=task.title
            binding.tvDesc.text=task.description
        }
    }

}