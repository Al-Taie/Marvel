package com.altaie.marvel.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TB_CHARACTERS")
data class CharacterEntity(
    @PrimaryKey
    val id: Int?,
    val description: String?,
    val modified: String?,
    val name: String?,
    @ColumnInfo(name = "image_url")
    val imgUrl: String?
)
