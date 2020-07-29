package com.github.tlaabs.githubexplorer

import android.app.Application
import com.github.tlaabs.githubexplorer.di.clientModule
import com.github.tlaabs.githubexplorer.di.networkModule
import com.github.tlaabs.githubexplorer.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GlobalApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@GlobalApplication)
            modules(viewModelModule)
            modules(networkModule)
            modules(clientModule)
        }
    }
}