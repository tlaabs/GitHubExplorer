package com.github.tlaabs.githubexplorer.listener

interface FilterListener {
    fun showFilterDialog()
    fun onFilterChanged(filter : String)
}