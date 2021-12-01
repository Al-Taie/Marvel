package com.altaie.marvel.data.remote.response.base


import com.google.gson.annotations.SerializedName

data class SubList(
    @SerializedName("available")
    val available: Int?,
    @SerializedName("collectionURI")
    val collectionURI: String?,
    @SerializedName("items")
    val items: List<SubItem>?,
    @SerializedName("returned")
    val returned: Int?
)