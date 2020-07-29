package com.github.tlaabs.githubexplorer.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.github.tlaabs.githubexplorer.base.BaseViewModel
import com.github.tlaabs.githubexplorer.model.MainContent
import com.github.tlaabs.githubexplorer.network.FetchState
import com.github.tlaabs.githubexplorer.network.client.GitHubClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(
    val gitHubClient: GitHubClient
) : BaseViewModel() {
    val init = MutableLiveData<MainContent>()
    val fetchState = FetchState()
    val search = MutableLiveData<String>().apply { value = "tlaabs" }
    var filterValue = "created"

    fun loadMore(page: Int, size: Int) {
        val searchValue = search.value!!

        if (fetchState.isRefreshing) { //Init
            addDisposable(
                gitHubClient.fetchInit(page,size,searchValue,filterValue)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        init.value = it
                    }, { e ->
                        fetchState.onError() })
            )
        } else { //loadmore
            addDisposable(
                gitHubClient.fetchUserRepos(searchValue, page, size, filterValue)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        init.value = MainContent(null, null, it)
                    }, { e ->
                        fetchState.onError()
                    })
            )
        }
    }
}