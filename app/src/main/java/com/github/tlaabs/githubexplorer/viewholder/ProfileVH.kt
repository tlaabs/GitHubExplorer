package com.github.tlaabs.githubexplorer.viewholder

import android.view.View
import com.github.tlaabs.githubexplorer.base.BaseViewHolder
import com.github.tlaabs.githubexplorer.databinding.ListItemBinding
import com.github.tlaabs.githubexplorer.databinding.ListUserBinding
import com.github.tlaabs.githubexplorer.model.Repository
import com.github.tlaabs.githubexplorer.model.User

class ProfileVH(view : View) : BaseViewHolder(view){
    private val binding : ListUserBinding = binding(view)
    override fun bindData(data: Any) {
        if(data is User){
            binding.item = data
        }
    }
}