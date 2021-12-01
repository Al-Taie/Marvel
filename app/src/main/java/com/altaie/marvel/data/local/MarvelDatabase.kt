package com.altaie.marvel.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.altaie.marvel.data.local.daos.MarvelDto
import com.altaie.marvel.data.local.entities.CharacterEntity
import com.altaie.marvel.data.local.entities.ComicEntity

@Database(entities = [CharacterEntity::class, ComicEntity::class], version = 1, exportSchema = false)
//@TypeConverters(Converters::class)
abstract class MarvelDatabase : RoomDatabase() {
    abstract fun marvelDao(): MarvelDto

    companion object {
        private const val DB_NAME = "DB_NOTE"
        @Volatile private var instance: MarvelDatabase? = null

        fun getInstance(context: Context) : MarvelDatabase {
            return instance ?: synchronized(this) { buildDatabase(context).also { instance = it } }
        }

        val getInstance get() = instance!!

        private fun buildDatabase(context: Context) : MarvelDatabase {
            return Room.databaseBuilder(context, MarvelDatabase::class.java, DB_NAME).build()
        }
    }
}