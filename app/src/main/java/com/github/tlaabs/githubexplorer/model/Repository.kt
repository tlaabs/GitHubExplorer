package com.github.tlaabs.githubexplorer.model

import com.google.gson.annotations.SerializedName

data class Repository(
    val name : String,
    @SerializedName("stargazers_count") val starCount : Int,
    val description : String
)