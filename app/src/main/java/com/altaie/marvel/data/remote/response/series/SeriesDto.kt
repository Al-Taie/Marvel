package com.altaie.marvel.data.remote.response.series


import com.altaie.marvel.data.remote.response.base.SubItem
import com.altaie.marvel.data.remote.response.base.SubList
import com.altaie.marvel.data.remote.response.base.Thumbnail
import com.altaie.marvel.data.remote.response.base.Url
import com.google.gson.annotations.SerializedName

data class SeriesDto(
    @SerializedName("characters")
    val characters: SubList?,
    @SerializedName("comics")
    val comics: SubList?,
    @SerializedName("creators")
    val creators: SubList?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("endYear")
    val endYear: Int?,
    @SerializedName("events")
    val events: SubList?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("modified")
    val modified: String?,
    @SerializedName("next")
    val next: SubItem?,
    @SerializedName("previous")
    val previous: SubItem?,
    @SerializedName("rating")
    val rating: String?,
    @SerializedName("resourceURI")
    val resourceURI: String?,
    @SerializedName("startYear")
    val startYear: Int?,
    @SerializedName("stories")
    val stories: SubList?,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("urls")
    val urls: List<Url>?
)