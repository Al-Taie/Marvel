package com.altaie.marvel.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "TB_EVENTS")
data class EventEntity(
    @PrimaryKey
    val id: Int?,
    val title: String?,
    val start: String?,
    val end: String?,
    val description: String?,
    val modified: String?,
    @ColumnInfo(name = "image_url")
    val imgUrl: String?
)
