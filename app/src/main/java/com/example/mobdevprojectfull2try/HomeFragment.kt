package com.example.mobdevprojectfull2try

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobdevprojectfull2try.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), TaskItemClickListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var taskViewModel: TaskViewModel
    private lateinit var adapter: TaskItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        taskViewModel = ViewModelProvider(requireActivity())[TaskViewModel::class.java]

        adapter = TaskItemAdapter(this)
        binding.todoListRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.todoListRecyclerView.adapter = adapter

        taskViewModel.taskItems.observe(viewLifecycleOwner) { list ->
            adapter.submitList(list.toList())
            println("List updated: ${list.size} items")
        }

        binding.newTaskButton.setOnClickListener {
            NewTaskSheet(null).show(parentFragmentManager, "newTaskTag")
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun completeTaskItem(taskItem: TaskItem) {
        taskViewModel.setCompleted(taskItem)
    }

    override fun editTaskItem(taskItem: TaskItem) {
        NewTaskSheet(taskItem).show(parentFragmentManager, "newTaskTag")
    }
}