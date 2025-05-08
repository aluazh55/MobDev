package com.example.mobdevprojectfull2try


import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.mobdevprojectfull2try.databinding.FragmentNewTaskSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class NewTaskSheet(var taskItem: TaskItem?) : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentNewTaskSheetBinding
    private lateinit var taskViewModel: TaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewTaskSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity()

        taskViewModel = ViewModelProvider(activity).get(TaskViewModel::class.java)

        if (taskItem != null) {
            binding.taskTitle.text = "Edit Task"
            val editable = Editable.Factory.getInstance()
            binding.name.text = editable.newEditable(taskItem!!.name)
            binding.desc.text = editable.newEditable(taskItem!!.desc)
        } else {
            binding.taskTitle.text = "New Task"
        }

        binding.saveButton.setOnClickListener {
            saveAction()
        }
    }

    private fun saveAction() {
        val name = binding.name.text.toString()
        val desc = binding.desc.text.toString()

        if (taskItem == null) {
            val newTask = TaskItem(name = name, desc = desc)
            taskViewModel.addTaskItem(newTask)
        } else {
            taskViewModel.updateTaskItem(taskItem!!.id, name, desc)
        }

        binding.name.setText("")
        binding.desc.setText("")
        dismiss()
    }
}
