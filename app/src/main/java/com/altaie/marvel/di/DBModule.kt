package com.altaie.marvel.di

import android.content.Context
import androidx.room.Room
import com.altaie.marvel.data.local.MarvelDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DBModule {
    private const val DB_NAME = "DB_CHARACTERS"

    @Singleton
    @Provides
    fun provideMarvelDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(context, MarvelDatabase::class.java, DB_NAME).build()
}