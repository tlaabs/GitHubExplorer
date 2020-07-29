package com.github.tlaabs.githubexplorer.network.operator

import com.github.tlaabs.githubexplorer.network.error.ApiException
import io.reactivex.SingleObserver
import io.reactivex.SingleOperator
import io.reactivex.disposables.Disposable
import retrofit2.Response

class ApiErrorOperator<T>() : SingleOperator<T, Response<T>> {
    override fun apply(observer: SingleObserver<in T>): SingleObserver<in Response<T>> {
        return object : SingleObserver<Response<T>> {
            override fun onSuccess(t: Response<T>) {
                if(t.isSuccessful){
                    observer.onSuccess(t.body()!!)
                } else {
                    observer.onError(ApiException("Error"))
                }
            }

            override fun onSubscribe(d: Disposable) {
                observer.onSubscribe(d)
            }

            override fun onError(e: Throwable) {
                observer.onError(ApiException("Error"))
            }
        }
    }
}