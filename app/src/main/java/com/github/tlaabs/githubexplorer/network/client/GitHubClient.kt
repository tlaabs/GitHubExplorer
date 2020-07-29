package com.github.tlaabs.githubexplorer.network.client

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.github.tlaabs.githubexplorer.model.Filter
import com.github.tlaabs.githubexplorer.model.MainContent
import com.github.tlaabs.githubexplorer.model.Repository
import com.github.tlaabs.githubexplorer.model.User
import com.github.tlaabs.githubexplorer.network.operator.ApiErrorOperator
import com.github.tlaabs.githubexplorer.network.service.GitHubService
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

class GitHubClient(
    private val gitHubService: GitHubService
) {
    fun fetchUser(username: String): Single<User> {
        return gitHubService.fetchUser(username)
            .subscribeOn(Schedulers.io())
            .lift(ApiErrorOperator())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun fetchUserRepos(
        username: String,
        page: Int,
        size: Int,
        sort: String
    ): Single<List<Repository>> {
        return gitHubService.fetchUserRepos(username, page, size, sort)
            .subscribeOn(Schedulers.io())
            .lift(ApiErrorOperator())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun fetchInit(
        page: Int, size: Int, search: String, filter: String
    ): Single<MainContent> {
        return Single.zip(
            gitHubService.fetchUser(search).subscribeOn(Schedulers.io()).lift(ApiErrorOperator()),
            gitHubService.fetchUserRepos(search, page, size, filter).subscribeOn(Schedulers.io()).lift(ApiErrorOperator()),
            BiFunction { user: User, repos: List<Repository> ->
                MainContent(user, Filter(filter), repos)
            }
        )
    }

}