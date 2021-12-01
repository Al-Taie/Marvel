package com.altaie.marvel.data.remote.response.base


import com.google.gson.annotations.SerializedName

data class SubItem(
    @SerializedName("name")
    val name: String?,
    @SerializedName("resourceURI")
    val resourceURI: String?
)