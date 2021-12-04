package com.altaie.marvel.domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Creator(
    val id: Int?,
    val name: String?,
    val modified: String?,
    val imgUrl: String?
)
