package com.altaie.marvel.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "TB_CREATORS")
data class CreatorEntity(
    @PrimaryKey
    val id: Int?,
    val name: String?,
    val modified: String?,
    @ColumnInfo(name = "image_url")
    val imgUrl: String?
)
