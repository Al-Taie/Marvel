package com.altaie.marvel.di
import com.altaie.marvel.data.local.MarvelDatabase
import com.altaie.marvel.data.remote.MarvelApiService
import com.altaie.marvel.domain.MarvelRepositoryImpl
import com.altaie.marvel.domain.mapper.CharacterMapper
import com.altaie.marvel.domain.mapper.ComicMapper
import com.altaie.marvel.domain.mapper.MarvelMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {
    @Singleton
    @Provides
    fun provideRepository(
        apiService: MarvelApiService,
        marvelDatabase: MarvelDatabase,
        marvelMapper: MarvelMapper
    ) = MarvelRepositoryImpl(apiService, marvelDatabase, marvelMapper)


    @Singleton
    @Provides
    fun provideCharacterMapper() = CharacterMapper()

    @Singleton
    @Provides
    fun provideComicMapper() = ComicMapper()
}