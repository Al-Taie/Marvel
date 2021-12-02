package com.altaie.marvel.di.modules

import com.altaie.marvel.data.local.MarvelDatabase
import com.altaie.marvel.data.remote.MarvelApiService
import com.altaie.marvel.domain.MarvelRepositoryImpl
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
        marvelDatabase: MarvelDatabase
    ) = MarvelRepositoryImpl(apiService, marvelDatabase)
}