package com.github.tlaabs.githubexplorer.di

import com.github.tlaabs.githubexplorer.network.client.GitHubClient
import org.koin.dsl.module

val clientModule = module {
    single { GitHubClient(get()) }
}