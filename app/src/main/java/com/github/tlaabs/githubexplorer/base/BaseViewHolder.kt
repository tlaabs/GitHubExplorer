package com.github.tlaabs.githubexplorer.base

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.skydoves.baserecyclerviewadapter.BaseViewHolder

abstract class BaseViewHolder(view : View) : BaseViewHolder(view){
    fun <T : ViewDataBinding> binding(view : View) : T {
        return DataBindingUtil.bind(view) ?: throw IllegalArgumentException("layout match error")
    }
    override fun onLongClick(v: View?): Boolean = false
    override fun onClick(v: View?) {}
}