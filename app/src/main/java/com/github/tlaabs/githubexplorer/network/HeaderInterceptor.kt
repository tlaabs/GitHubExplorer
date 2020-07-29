package com.github.tlaabs.githubexplorer.network

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
            .newBuilder()
            .addHeader("Authorization", "token 35475e8e33cf0bb9dbf9f050b2bdf214c17d4792")
            .build()
        return chain.proceed(request)
    }
}