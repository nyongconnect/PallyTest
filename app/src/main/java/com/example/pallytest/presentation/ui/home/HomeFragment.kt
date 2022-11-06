package com.example.pallytest.presentation.ui.home

import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pallytest.R
import com.example.pallytest.databinding.FragmentHomeBinding
import com.example.pallytest.presentation.adapters.EventAdapter
import com.example.pallytest.presentation.adapters.MilongasAdapter
import com.example.pallytest.presentation.adapters.TeachersAdapter
import com.example.pallytest.presentation.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun getViewBinding(): FragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater)

    private val viewModel: HomeViewModel by activityViewModels()

    lateinit var eventAdapter: EventAdapter
    lateinit var milongasAdapter: MilongasAdapter
    lateinit var teachersAdapter: TeachersAdapter

    override fun setUp() {
        eventAdapter = EventAdapter(requireContext()) {

        }

        milongasAdapter = MilongasAdapter(requireContext()) {

        }

        teachersAdapter = TeachersAdapter(requireContext()) {

        }

        binding.viewEvents.itemList.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
            adapter = eventAdapter
        }

        binding.viewTeachers.itemList.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
            adapter = teachersAdapter
        }

        binding.viewMilongas.itemList.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
            adapter = milongasAdapter
        }

        binding.viewMilongas.txtItemHeader.text = getString(R.string.text_milogan_near_you)
        binding.viewTeachers.txtItemHeader.text = getString(R.string.text_teachers_near_you)
        binding.viewEvents.txtItemHeader.text = getString(R.string.text_events)
    }

    override fun observeData() {
        viewModel.state.observe(viewLifecycleOwner) {
            when(it.hasData) {
                true -> {
                    eventAdapter.update(it.events)
                    milongasAdapter.update(it.milongas)
                    teachersAdapter.update(it.teachers)
                }
                else -> {

                }
            }
        }
    }

}