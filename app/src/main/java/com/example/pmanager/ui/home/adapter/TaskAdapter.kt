package com.example.pmanager.ui.home.adapter

import android.graphics.Color
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.pmanager.databinding.ItemTaskBinding
import com.example.pmanager.model.Task

class TaskAdapter(
    private val onLongClick: (Task) -> Unit,
    private val onClick: (Task) -> Unit,
    private val onSuccess: (Task) -> Unit,
) :
    Adapter<TaskAdapter.TaskViewHolder>() {

    private val list: ArrayList<Task> = arrayListOf()

    fun addTasks(task: List<Task>) {
        list.clear()
        list.addAll(task)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(list.get(position))
    }

    override fun getItemCount(): Int {
        return list.size
    }


    inner class TaskViewHolder(private val binding: ItemTaskBinding) : ViewHolder(binding.root) {
        fun bind(task: Task) = with(binding) {

            tvTitle.text = task.title
            tvDesc.text = task.description
            checkbox.isChecked = task.isSuccess

            checkbox.setOnCheckedChangeListener { _, isSuccess ->
                onSuccess(task.copy(isSuccess = isSuccess))
            }

            itemView.setOnLongClickListener {
                onLongClick(task)
                false
            }
            itemView.setOnClickListener {
                onClick(task)
            }

            itemView.setBackgroundColor(if (adapterPosition%2==0)Color.BLACK else Color.WHITE)
            tvTitle.setTextColor(if (adapterPosition%2==0)Color.WHITE else Color.BLACK)
            tvDesc.setTextColor(if (adapterPosition%2==0)Color.WHITE else Color.BLACK)

            tvTitle.paintFlags = if (task.isSuccess) tvTitle.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG else 0
            tvDesc.paintFlags = if (task.isSuccess) tvTitle.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG else 0

        }
    }
}