package com.local.balodseva.ui.worker

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.chip.Chip
import com.local.balodseva.data.model.Worker
import com.local.balodseva.data.repository.WorkerRepository
import com.local.balodseva.databinding.FragmentWorkerDetailBinding

class WorkerDetailFragment : Fragment() {

    private var _binding: FragmentWorkerDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWorkerDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val workerId = arguments?.getString("workerId") ?: return
        val worker = WorkerRepository.getWorkerById(workerId) ?: return

        bindWorkerData(worker)
        setupButtons(worker)
    }

    private fun bindWorkerData(worker: Worker) {
        binding.tvWorkerName.text = worker.nameHindi
        binding.tvTradeBadge.text = worker.tradeHindi
        binding.tvRating.text = worker.rating.toString()
        binding.tvReviewCount.text = "(${formatCount(worker.totalReviews)}k रेटिंग)"
        binding.tvLocation.text = worker.location
        binding.tvExperience.text = "${worker.yearsExperience}+"
        binding.tvJobs.text = "${worker.totalJobs}+"
        binding.tvLanguage.text = worker.language

        // Add services as chips dynamically
        binding.chipGroupServices.removeAllViews()
        worker.services.forEach { service ->
            val chip = Chip(requireContext()).apply {
                text = service
                isClickable = false
                setChipBackgroundColorResource(com.local.balodseva.R.color.color_primary_container)
                setTextColor(resources.getColor(com.local.balodseva.R.color.color_primary, null))
                chipCornerRadius = 20f
            }
            binding.chipGroupServices.addView(chip)
        }
    }

    private fun setupButtons(worker: Worker) {
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnCall.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse(worker.phone))
            startActivity(intent)
        }

        binding.btnWhatsapp.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(worker.whatsapp))
            startActivity(intent)
        }

        binding.btnFav.setOnClickListener {
            // TODO: Implement favourites in V2
        }

        binding.btnShare.setOnClickListener {
            val shareText = "BalodSeva पर ${worker.nameHindi} को देखें — ${worker.tradeHindi}\n" +
                "📍 ${worker.location}\n⭐ ${worker.rating} रेटिंग\n\n" +
                "कॉल करें: ${worker.phone}"
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, shareText)
            }
            startActivity(Intent.createChooser(intent, "Share via"))
        }
    }

    private fun formatCount(count: Int): String {
        return if (count >= 1000) String.format("%.1f", count / 1000.0) else count.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
