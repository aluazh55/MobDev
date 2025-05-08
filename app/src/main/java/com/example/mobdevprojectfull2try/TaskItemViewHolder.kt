package com.example.mobdevprojectfull2try



import android.content.Context
import android.graphics.Paint
import androidx.recyclerview.widget.RecyclerView
import com.example.mobdevprojectfull2try.databinding.TaskItemCellBinding

class TaskItemViewHolder(
    private val context: Context,
    private val binding: TaskItemCellBinding,
    private val clickListener: TaskItemClickListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bindTaskItem(taskItem: TaskItem) {
        binding.name.text = taskItem.name

        // Отметка зачёркиванием, если выполнено
        if (taskItem.isCompleted) {
            binding.name.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            binding.name.paintFlags = 0
        }

        // Установка иконки
        binding.completeButton.setImageResource(taskItem.imageResource())
        binding.completeButton.setColorFilter(taskItem.imageColor(context))

        // Обработчики кликов
        binding.completeButton.setOnClickListener {
            clickListener.completeTaskItem(taskItem)
        }
        binding.taskCellContainer.setOnClickListener {
            clickListener.editTaskItem(taskItem)
        }

        // Убираем отображение времени
        binding.dueTime.text = ""
    }
}
