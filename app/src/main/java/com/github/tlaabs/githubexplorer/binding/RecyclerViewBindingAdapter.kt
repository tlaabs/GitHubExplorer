package com.github.tlaabs.githubexplorer.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.tlaabs.githubexplorer.view.adapter.MainAdapter
import com.github.tlaabs.githubexplorer.model.MainContent
import com.github.tlaabs.githubexplorer.network.FetchState

object RecyclerViewBindingAdapter {
    @JvmStatic
    @BindingAdapter("load","fetchState")
    fun bindLoadItem(
        recyclerView: RecyclerView,
        content: MainContent?,
        fetchState: FetchState
    ) {
        checkNotNull(content) { return }
        val adapter = recyclerView.adapter
        if (adapter is MainAdapter) {
            if(fetchState.isRefreshing){
                adapter.clear()
                adapter.init(content)
                fetchState.isRefreshing = false
                fetchState.isOnLoading = false
            }else{
                if (content.repos.isEmpty()) {
                    fetchState.isOnLast = true
                } else {
                    adapter.addRepoItems(content.repos)
                }
                fetchState.isOnLoading = false
            }
        }
    }
}