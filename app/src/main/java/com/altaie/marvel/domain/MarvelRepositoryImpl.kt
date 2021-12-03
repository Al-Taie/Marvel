package com.altaie.marvel.domain

import com.altaie.marvel.data.local.MarvelDatabase
import com.altaie.marvel.data.remote.MarvelApiService
import com.altaie.marvel.data.remote.State
import com.altaie.marvel.domain.mapper.BaseMapper
import com.altaie.marvel.domain.mapper.Mapper
import com.altaie.marvel.domain.mapper.MarvelMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject


class MarvelRepositoryImpl @Inject constructor(
    private val apiService: MarvelApiService,
    private val marvelDatabase: MarvelDatabase,
    private val marvelMapper: MarvelMapper
) : MarvelRepository {
    fun getAllCharacters() = wrapWithFlow { apiService.getAllCharacters() }
    fun getAllComics() = wrapWithFlow { apiService.getAllComics() }
    fun getAllCreators() = wrapWithFlow { apiService.getAllCreators() }
    fun getAllEvents() = wrapWithFlow { apiService.getAllEvents() }
    fun getAllSeries() = wrapWithFlow { apiService.getAllSeries() }
    fun getAllStories() = wrapWithFlow { apiService.getAllStories() }

    private fun <T> wrapWithFlow(function: suspend () -> Response<T>): Flow<State<T?>> =
        flow {
            emit(State.Loading)
            emit(checkIfSuccessful(function()))
        }.catch {
            emit(State.Error(it.message.toString()))
        }

    private fun <T> checkIfSuccessful(result: Response<T>): State<T?> =
        try {
            if (result.isSuccessful) {
                State.Success(result.body())
            } else {
                State.Error(result.message())
            }
        } catch (e: Exception) {
            State.Error(e.message.toString())
        }
}