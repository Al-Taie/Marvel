package com.altaie.marvel.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.altaie.marvel.data.local.entities.*

@Dao
interface MarvelDto {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacters(characters: List<CharacterEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComics(characters: List<ComicEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCreators(creators: List<CreatorEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEvents(events: List<EventEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSeries(series: List<SeriesEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStories(stories: List<StoryEntity>)

    @Query("SELECT * FROM TB_CHARACTERS")
    suspend fun getAllCharacters() : List<CharacterEntity>

    @Query("SELECT * FROM TB_COMICS")
    suspend fun getAllComics() : List<ComicEntity>

    @Query("SELECT * FROM TB_CREATORS")
    suspend fun getAllCreators() : List<CreatorEntity>

    @Query("SELECT * FROM TB_EVENTS")
    suspend fun getAllEvents() : List<EventEntity>

    @Query("SELECT * FROM TB_SERIES")
    suspend fun getAllSeries() : List<SeriesEntity>

    @Query("SELECT * FROM TB_STORIES")
    suspend fun getAllStories() : List<StoryEntity>
}