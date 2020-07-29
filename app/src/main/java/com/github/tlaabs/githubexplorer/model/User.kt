package com.github.tlaabs.githubexplorer.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("name") val name : String,
    @SerializedName("avatar_url") val avatarUrl : String
)