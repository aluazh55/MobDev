package com.example.mobdevprojectfull2try


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import java.util.*

class TaskViewModel: ViewModel()
{
    var taskItems = MutableLiveData<MutableList<TaskItem>>()

    init {
        taskItems.value = mutableListOf()
    }

    fun addTaskItem(newTask: TaskItem)
    {
        val list = taskItems.value
        list!!.add(newTask)
        taskItems.postValue(list)
    }

    fun updateTaskItem(id: UUID, name: String, desc: String)
    {
        val list = taskItems.value
        val task = list!!.find { it.id == id }!!
        task.name = name
        task.desc = desc

        taskItems.postValue(list)
    }

    fun setCompleted(taskItem: TaskItem) {
        val list = taskItems.value?.toMutableList() ?: return
        val index = list.indexOfFirst { it.id == taskItem.id }
        if (index != -1) {
            val old = list[index]
            val updated = old.copy(isCompleted = !old.isCompleted) // ✅ копия с новым состоянием
            list[index] = updated
            taskItems.postValue(list)
        }
    }
}