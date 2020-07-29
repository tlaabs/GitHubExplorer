package com.github.tlaabs.githubexplorer.model

data class MainContent(
    val user: User? = null,
    val filter: Filter? = null,
    val repos: List<Repository>
)