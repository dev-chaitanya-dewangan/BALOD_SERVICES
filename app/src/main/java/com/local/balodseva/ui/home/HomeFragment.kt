package com.local.balodseva.ui.home

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.local.balodseva.R
import com.local.balodseva.data.repository.WorkerRepository
import com.local.balodseva.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSearchBar()
        setupCategoryChips()
        setupHeroCTA()
    }

    private fun setupSearchBar() {
        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val query = s.toString().trim()
                if (query.isNotEmpty()) {
                    // Navigate to services with query
                    // findNavController().navigate(...)
                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

    private fun setupCategoryChips() {
        binding.chipAll.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) navigateToServices("all")
        }
        binding.chipPlumber.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) navigateToServices("plumber")
        }
        binding.chipElectrician.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) navigateToServices("electrician")
        }
        binding.chipMason.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) navigateToServices("mason")
        }
        binding.chipContractor.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) navigateToServices("contractor")
        }
        binding.chipMechanic.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) navigateToServices("mechanic")
        }
    }

    private fun setupHeroCTA() {
        binding.btnHeroCta.setOnClickListener {
            findNavController().navigate(R.id.servicesFragment)
        }
    }

    private fun navigateToServices(categoryId: String) {
        findNavController().navigate(R.id.servicesFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
