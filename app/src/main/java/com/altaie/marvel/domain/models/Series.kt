package com.altaie.marvel.domain.models

data class Series(
    val id: Int?,
    val title: String?,
    val rating: String?,
    val startYear: Int?,
    val endYear: Int?,
    val description: String?,
    val modified: String?,
    val type: String?,
    val imgUrl: String?
)
