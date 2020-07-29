package com.github.tlaabs.githubexplorer.network.service

import com.github.tlaabs.githubexplorer.model.Repository
import com.github.tlaabs.githubexplorer.model.User
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubService {
    @GET("/users/{username}")
    fun fetchUser(
        @Path("username") username : String
    ) : Single<Response<User>>

    @GET("/users/{username}/repos")
    fun fetchUserRepos(
        @Path("username") username : String,
        @Query("page")page : Int,
        @Query("per_page")size : Int,
        @Query("sort")sort : String
    ) : Single<Response<List<Repository>>>
}