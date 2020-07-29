package com.github.tlaabs.githubexplorer.base

import android.app.Dialog
import android.content.Context
import android.graphics.Point
import android.os.Bundle
import android.view.ViewGroup
import android.view.WindowManager

abstract class BaseDialog(private val mContext : Context) : Dialog(mContext) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        window?.setBackgroundDrawableResource(android.R.color.transparent)
    }

    abstract fun adjustWindow()
    fun adjustWindowSize(xRatio : Float, yRatio : Float){
        val windowManager = mContext.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        val params: ViewGroup.LayoutParams? = window?.attributes
        val deviceWidth = size.x
        val deviceHeight = size.y
        params?.width = (deviceWidth * xRatio).toInt()
        if(yRatio > 0.0f) {
            params?.height = (deviceHeight * yRatio).toInt()
        } else {
            params?.height = ViewGroup.LayoutParams.WRAP_CONTENT
        }
        window?.attributes = params as WindowManager.LayoutParams
    }
    fun adjustWindowGravity(gravity: Int){
        window?.setGravity(gravity)
    }
}