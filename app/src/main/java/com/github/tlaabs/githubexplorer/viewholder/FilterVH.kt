package com.github.tlaabs.githubexplorer.viewholder

import android.view.View
import com.github.tlaabs.githubexplorer.base.BaseViewHolder
import com.github.tlaabs.githubexplorer.databinding.ListFilterBinding
import com.github.tlaabs.githubexplorer.databinding.ListItemBinding
import com.github.tlaabs.githubexplorer.databinding.ListUserBinding
import com.github.tlaabs.githubexplorer.listener.FilterListener
import com.github.tlaabs.githubexplorer.model.Filter
import com.github.tlaabs.githubexplorer.model.Repository
import com.github.tlaabs.githubexplorer.model.User

class FilterVH(
    view: View,
    private val listener: FilterListener
) : BaseViewHolder(view) {
    private val binding: ListFilterBinding = binding(view)
    override fun bindData(data: Any) {
        if (data is Filter) {
            binding.item = data
            binding.filter.setOnClickListener { listener.showFilterDialog() }
        }
    }
}