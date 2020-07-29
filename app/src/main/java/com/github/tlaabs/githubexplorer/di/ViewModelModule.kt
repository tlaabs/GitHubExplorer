package com.github.tlaabs.githubexplorer.di

import com.github.tlaabs.githubexplorer.viewmodel.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}