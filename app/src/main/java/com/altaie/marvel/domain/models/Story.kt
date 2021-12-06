package com.altaie.marvel.domain.models

import androidx.room.PrimaryKey

data class Story(
    @PrimaryKey
    val id: Int?,
    val title: String?,
    val description: String?,
    val modified: String?,
    val type: String?,
    val imgUrl: String?
)