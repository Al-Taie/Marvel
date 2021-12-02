package com.altaie.marvel.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.altaie.marvel.data.local.daos.MarvelDto
import com.altaie.marvel.data.local.entities.CharacterEntity
import com.altaie.marvel.data.local.entities.ComicEntity

@Database(
    entities = [CharacterEntity::class, ComicEntity::class],
    version = 1,
    exportSchema = false
)
//@TypeConverters(Converters::class)
abstract class MarvelDatabase : RoomDatabase() {
    abstract fun marvelDao(): MarvelDto
}