package com.example.mobdevprojectfull2try



import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.mobdevprojectfull2try.databinding.TaskItemCellBinding

class TaskItemAdapter(
    private val clickListener: TaskItemClickListener
) : ListAdapter<TaskItem, TaskItemViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskItemViewHolder {
        val binding = TaskItemCellBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskItemViewHolder(parent.context, binding, clickListener)
    }

    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {
        val taskItem = getItem(position)
        holder.bindTaskItem(taskItem)
    }

    class DiffCallback : DiffUtil.ItemCallback<TaskItem>() {
        override fun areItemsTheSame(oldItem: TaskItem, newItem: TaskItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TaskItem, newItem: TaskItem): Boolean {
            return oldItem == newItem
        }
    }
}
