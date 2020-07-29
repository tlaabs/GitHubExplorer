package com.github.tlaabs.githubexplorer.network

class FetchState (
    var isOnLoading : Boolean = false,
    var isOnError : Boolean = false,
    var isOnLast : Boolean = false,
    var isRefreshing : Boolean = false
) {
    fun reset(){
        this.isOnLoading = false
        this.isOnError = false
        this.isOnLast = false
        this.isRefreshing = false
    }
    fun onError(){
        reset()
        this.isOnError = true
    }
}