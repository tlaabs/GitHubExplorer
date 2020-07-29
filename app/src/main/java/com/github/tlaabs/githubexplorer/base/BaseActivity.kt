package com.github.tlaabs.githubexplorer.base

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity : AppCompatActivity() {
    fun <T : ViewDataBinding> binding(
        @LayoutRes layout : Int
    ) : T = DataBindingUtil.setContentView(this, layout)
}