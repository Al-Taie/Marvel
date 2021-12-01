package com.altaie.marvel.data.remote.response.characters


import com.altaie.marvel.data.remote.response.base.SubList
import com.google.gson.annotations.SerializedName

data class CharacterDto(
    @SerializedName("comics")
    val comics: SubList?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("events")
    val events: SubList?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("modified")
    val modified: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("resourceURI")
    val resourceURI: String?,
    @SerializedName("series")
    val series: SubList?,
    @SerializedName("stories")
    val stories: SubList?,
    @SerializedName("thumbnail")
    val thumbnail: SubList?,
    @SerializedName("urls")
    val urls: List<SubList>?
)