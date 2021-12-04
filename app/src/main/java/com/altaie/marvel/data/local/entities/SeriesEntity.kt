package com.altaie.marvel.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "TB_SERIES")
data class SeriesEntity(
    @PrimaryKey
    val id: Int?,
    val title: String?,
    val rating: String?,
    @ColumnInfo(name = "start_year")
    val startYear: Int?,
    @ColumnInfo(name = "end_year")
    val endYear: Int?,
    val description: String?,
    val modified: String?,
    val type: String?,
    @ColumnInfo(name = "image_url")
    val imgUrl: String?
)
