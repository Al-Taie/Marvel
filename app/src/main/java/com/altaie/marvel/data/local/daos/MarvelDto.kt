package com.altaie.marvel.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.altaie.marvel.data.local.entities.CharacterEntity
import com.altaie.marvel.data.local.entities.ComicEntity

@Dao
interface MarvelDto {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacters(characters: List<CharacterEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComics(characters: List<ComicEntity>)
}