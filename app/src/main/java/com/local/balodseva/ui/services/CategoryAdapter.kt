package com.local.balodseva.ui.services

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.local.balodseva.data.model.ServiceCategory
import com.local.balodseva.databinding.ItemCategoryCardBinding

class CategoryAdapter(
    private val onCategoryClick: (ServiceCategory) -> Unit
) : ListAdapter<ServiceCategory, CategoryAdapter.CategoryViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = ItemCategoryCardBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CategoryViewHolder(
        private val binding: ItemCategoryCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(category: ServiceCategory) {
            binding.tvCategoryNameHindi.text = category.nameHindi
            binding.tvCategoryDesc.text = category.descriptionHindi

            binding.btnSeeService.setOnClickListener {
                onCategoryClick(category)
            }

            binding.root.setOnClickListener {
                onCategoryClick(category)
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<ServiceCategory>() {
        override fun areItemsTheSame(oldItem: ServiceCategory, newItem: ServiceCategory) =
            oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: ServiceCategory, newItem: ServiceCategory) =
            oldItem == newItem
    }
}
