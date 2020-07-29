package com.github.tlaabs.githubexplorer.view.dialog

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import com.github.tlaabs.githubexplorer.R
import com.github.tlaabs.githubexplorer.base.BaseDialog
import com.github.tlaabs.githubexplorer.listener.FilterListener
import kotlinx.android.synthetic.main.dialog_filter.*

class FilterDialog(
    private val mContext : Context,
    private val listener : FilterListener
) : BaseDialog(mContext) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_filter)
        adjustWindow()
        initView()

    }
    override fun adjustWindow() {
        adjustWindowSize(1.0f, 0.0f)
        adjustWindowGravity(Gravity.BOTTOM)
    }

    private fun initView(){
        filter_created_txt.setOnClickListener {
            listener.onFilterChanged("created")
            dismiss()
        }
        filter_updated_btn_txt.setOnClickListener {
            listener.onFilterChanged("updated")
            dismiss()
        }
    }
}