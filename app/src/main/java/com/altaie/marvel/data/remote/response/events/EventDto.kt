package com.altaie.marvel.data.remote.response.events


import com.altaie.marvel.data.remote.response.base.SubList
import com.altaie.marvel.data.remote.response.base.SubItem
import com.altaie.marvel.data.remote.response.base.Thumbnail
import com.altaie.marvel.data.remote.response.base.Url
import com.google.gson.annotations.SerializedName

data class EventDto(
    @SerializedName("characters")
    val characters: SubItem?,
    @SerializedName("comics")
    val comics: SubItem?,
    @SerializedName("creators")
    val creators: SubItem?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("end")
    val end: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("modified")
    val modified: String?,
    @SerializedName("next")
    val next: SubList?,
    @SerializedName("previous")
    val previous: SubList?,
    @SerializedName("resourceURI")
    val resourceURI: String?,
    @SerializedName("series")
    val series: SubItem?,
    @SerializedName("start")
    val start: String?,
    @SerializedName("stories")
    val stories: SubItem?,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("urls")
    val urls: List<Url>?
)