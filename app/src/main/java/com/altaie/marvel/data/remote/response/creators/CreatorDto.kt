package com.altaie.marvel.data.remote.response.creators


import com.altaie.marvel.data.remote.response.base.SubList
import com.altaie.marvel.data.remote.response.base.Thumbnail
import com.altaie.marvel.data.remote.response.base.Url
import com.google.gson.annotations.SerializedName

data class CreatorDto(
    @SerializedName("comics")
    val comics: SubList?,
    @SerializedName("events")
    val events: SubList?,
    @SerializedName("firstName")
    val firstName: String?,
    @SerializedName("fullName")
    val fullName: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("lastName")
    val lastName: String?,
    @SerializedName("middleName")
    val middleName: String?,
    @SerializedName("modified")
    val modified: String?,
    @SerializedName("resourceURI")
    val resourceURI: String?,
    @SerializedName("series")
    val series: SubList?,
    @SerializedName("stories")
    val stories: SubList?,
    @SerializedName("suffix")
    val suffix: String?,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail?,
    @SerializedName("urls")
    val urls: List<Url>?
)