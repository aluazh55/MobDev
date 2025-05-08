package com.example.mobdevprojectfull2try

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobdevprojectfull2try.databinding.FragmentFifthBinding

class FifthFragment : Fragment() {

    private var _binding: FragmentFifthBinding? = null
    private val binding get() = _binding!!

    private lateinit var newsList: ArrayList<News>
    private lateinit var imageIds: Array<Int>
    private lateinit var headings: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFifthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageIds = arrayOf(
            R.drawable.cc,
            R.drawable.dd
        )

        headings = arrayOf(
            "Taskent square",
            "Urban Jungle"
        )

        newsList = arrayListOf()
        for (i in imageIds.indices) {
            newsList.add(News(imageIds[i], headings[i]))
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = MyAdapter(newsList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
