package com.github.tlaabs.githubexplorer.network

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
            .newBuilder()
            .addHeader("Authorization", "token 192d7d9f5667335012641a9512a69053580539b7")
            .build()
        return chain.proceed(request)
    }
}