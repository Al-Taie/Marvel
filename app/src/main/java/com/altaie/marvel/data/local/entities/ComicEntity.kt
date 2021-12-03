package com.altaie.marvel.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class ComicEntity(
    @PrimaryKey
    val id: Int?,
    val description: String?,
    val modified: String?,
    val title: String?,
    @ColumnInfo(name = "image_url")
    val imgUrl: String?
)
