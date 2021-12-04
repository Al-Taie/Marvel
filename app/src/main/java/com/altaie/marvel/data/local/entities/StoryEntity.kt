package com.altaie.marvel.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "TB_STORIES")
data class StoryEntity(
    @PrimaryKey
    val id: Int?,
    val title: String?,
    val description: String?,
    val modified: String?,
    val type: String?,
    @ColumnInfo(name = "image_url")
    val imgUrl: String?
)
