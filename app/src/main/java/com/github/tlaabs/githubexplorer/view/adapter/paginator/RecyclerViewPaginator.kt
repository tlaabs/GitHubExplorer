package com.github.tlaabs.githubexplorer.view.adapter.paginator

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.tlaabs.githubexplorer.network.FetchState
import com.skydoves.baserecyclerviewadapter.BaseAdapter

class RecyclerViewPaginator(
    val recyclerView: RecyclerView,
    val loadMore: (Int, Int) -> Unit,
    val fetchState: FetchState
) : RecyclerView.OnScrollListener() {
    private var page = 1
    val size = 15
    private var threshold = 5

    private var layoutManager: LinearLayoutManager

    init {
        recyclerView.addOnScrollListener(this)
        layoutManager = recyclerView.layoutManager as LinearLayoutManager
    }

    fun refresh() {
        fetchState.reset()
        page = 1
        fetchState.isRefreshing = true
        loadMore(page++, size)
    }

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        val adapter = recyclerView.adapter as BaseAdapter
        val visibleItemCount = layoutManager.childCount
        val totalItemCount = adapter.itemCount
        val lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()
        if (fetchState.isOnLoading || fetchState.isOnLast) return
        if (visibleItemCount + lastVisibleItemPosition + threshold >= totalItemCount) {
            fetchState.isOnLoading = true
            loadMore(page++, size)
        }
    }
}