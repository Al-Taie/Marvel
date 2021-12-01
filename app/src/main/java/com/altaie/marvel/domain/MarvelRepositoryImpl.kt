package com.altaie.marvel.domain

import com.altaie.marvel.data.remote.Resources
import com.altaie.marvel.data.remote.response.base.BaseResponse
import com.altaie.marvel.data.remote.response.characters.CharactersDto
import com.altaie.marvel.data.remote.response.comics.ComicsDto
import com.altaie.marvel.data.remote.response.creators.CreatorDto
import com.altaie.marvel.data.remote.response.events.EventDto
import com.altaie.marvel.data.remote.response.series.SeriesDto
import com.altaie.marvel.data.remote.response.stories.StoryDto
import com.altaie.marvel.di.DependencyContainer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response

object MarvelRepositoryImpl : MarvelRepository {

    fun getAllCharacters() = wrapWithFlow { DependencyContainer.apiService.getAllCharacters() }
    fun getAllComics() {}
    fun getAllCreators() {}
    fun getAllEvents() {}
    fun getAllSeries() {}
    fun getAllStories() {}

    private fun <T> wrapWithFlow(function: suspend () -> Response<T>): Flow<Resources<T?>> =
        flow {
            emit(Resources.Loading)
            emit(checkIfSuccessful(function()))
        }.catch {
            emit(Resources.Error(it.message.toString()))
        }

    private fun <T> checkIfSuccessful(result: Response<T>): Resources<T?> =
        try {
            if (result.isSuccessful) {
                Resources.Success(result.body())
            } else {
                Resources.Error(result.message())
            }
        } catch (e: Exception) {
            Resources.Error(e.message.toString())
        }

}