package com.local.balodseva.ui.services

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.local.balodseva.R
import com.local.balodseva.data.repository.WorkerRepository
import com.local.balodseva.databinding.FragmentServicesBinding

class ServicesFragment : Fragment() {

    private var _binding: FragmentServicesBinding? = null
    private val binding get() = _binding!!
    private lateinit var categoryAdapter: CategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentServicesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupCategoryList()
    }

    private fun setupCategoryList() {
        categoryAdapter = CategoryAdapter { category ->
            // Navigate to worker list for this category
            // For V1: Pass category ID as argument to a WorkerListFragment (future)
            // For now, navigate to the first worker's detail as demo
            val workers = WorkerRepository.getWorkersByCategory(category.id)
            if (workers.isNotEmpty()) {
                val bundle = bundleOf("workerId" to workers.first().id)
                findNavController().navigate(R.id.workerDetailFragment, bundle)
            }
        }

        binding.rvCategories.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = categoryAdapter
        }

        categoryAdapter.submitList(WorkerRepository.getAllCategories())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
