package com.github.tlaabs.githubexplorer.view

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.github.tlaabs.githubexplorer.R
import com.github.tlaabs.githubexplorer.view.adapter.MainAdapter
import com.github.tlaabs.githubexplorer.view.adapter.paginator.RecyclerViewPaginator
import com.github.tlaabs.githubexplorer.base.BaseActivity
import com.github.tlaabs.githubexplorer.databinding.ActivityMainBinding
import com.github.tlaabs.githubexplorer.listener.FilterListener
import com.github.tlaabs.githubexplorer.view.dialog.FilterDialog
import com.github.tlaabs.githubexplorer.viewmodel.MainViewModel
import com.jakewharton.rxbinding3.widget.textChanges
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import org.koin.android.viewmodel.ext.android.getViewModel
import java.sql.Time
import java.util.concurrent.TimeUnit

class MainActivity : BaseActivity(), FilterListener {
    private lateinit var binding : ActivityMainBinding
    private lateinit var recyclerAdapter : MainAdapter
    private lateinit var paginator : RecyclerViewPaginator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = binding(R.layout.activity_main)
        binding.apply {
            viewModel = getViewModel<MainViewModel>()
            lifecycleOwner = this@MainActivity
        }

        initView()
        initObserver()
    }

    private fun initView(){
        recyclerAdapter = MainAdapter(this)
        binding.run {
            recyclerView.adapter = recyclerAdapter
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            paginator = RecyclerViewPaginator(
                recyclerView, {page,size -> loadMore(page,size)},
                viewModel!!.fetchState
            )
        }
    }

    private fun initObserver(){
        binding.searchEdit.textChanges()
            .debounce(500, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                binding.viewModel!!.search.value = it.toString()
                paginator.refresh()
            })

    }

    private fun loadMore(page : Int, size : Int){
        binding.viewModel!!.loadMore(page,size)
    }

    override fun showFilterDialog() {
        FilterDialog(this,this).show()
    }

    override fun onFilterChanged(filter: String) {
        binding.viewModel!!.updateFilter(filter)
        paginator.refresh()
    }
}
