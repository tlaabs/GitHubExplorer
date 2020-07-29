package com.github.tlaabs.githubexplorer.viewholder

import android.view.View
import com.github.tlaabs.githubexplorer.base.BaseViewHolder
import com.github.tlaabs.githubexplorer.databinding.ListItemBinding
import com.github.tlaabs.githubexplorer.model.Repository

class ItemVH(view : View) : BaseViewHolder(view){
    private val binding : ListItemBinding = binding(view)
    override fun bindData(data: Any) {
        if(data is Repository){
            binding.item = data
        }
    }
}