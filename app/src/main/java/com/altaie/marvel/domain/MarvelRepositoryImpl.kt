package com.altaie.marvel.domain

import com.altaie.marvel.data.local.MarvelDatabase
import com.altaie.marvel.data.local.entities.*
import com.altaie.marvel.data.remote.MarvelApiService
import com.altaie.marvel.data.remote.State
import com.altaie.marvel.data.remote.response.base.BaseResponse
import com.altaie.marvel.domain.mapper.Mapper
import com.altaie.marvel.domain.mapper.MarvelMapper
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject


class MarvelRepositoryImpl @Inject constructor(
    private val apiService: MarvelApiService,
    marvelDatabase: MarvelDatabase,
    private val marvelMapper: MarvelMapper
) : MarvelRepository {
    private val dao = marvelDatabase.marvelDao()

    suspend fun insertCharacters(characters: List<CharacterEntity>) = dao.insertCharacters(characters)
    suspend fun insertComics(comics: List<ComicEntity>) = dao.insertComics(comics)
    suspend fun insertCreators(creators: List<CreatorEntity>) = dao.insertCreators(creators)
    suspend fun insertEvents(events: List<EventEntity>) = dao.insertEvents(events)
    suspend fun insertSeries(series: List<SeriesEntity>) = dao.insertSeries(series)
    suspend fun insertStories(stories: List<StoryEntity>) = dao.insertStories(stories)

    fun getAllCharactersDto() = wrapWithFlow(apiService::getAllCharacters, marvelMapper.characterMapper)
    fun getAllCharacters() = wrapWithFlow(dao::getAllCharacters, marvelMapper.characterMapper)

    fun getAllComicsDto() = wrapWithFlow(apiService::getAllComics, marvelMapper.comicMapper)
    fun getAllComics() = wrapWithFlow(dao::getAllComics, marvelMapper.comicMapper)

    fun getAllCreatorsDto() = wrapWithFlow(apiService::getAllCreators, marvelMapper.creatorMapper)
    fun getAllCreators() = wrapWithFlow(dao::getAllCreators, marvelMapper.creatorMapper)

    fun getAllEventsDto() = wrapWithFlow(apiService::getAllEvents, marvelMapper.eventMapper)
    fun getAllEvents() = wrapWithFlow(dao::getAllEvents, marvelMapper.eventMapper)

    fun getAllSeriesDto() = wrapWithFlow(apiService::getAllSeries, marvelMapper.seriesMapper)
    fun getAllSeries() = wrapWithFlow(dao::getAllSeries, marvelMapper.seriesMapper)

    fun getAllStoriesDto() = wrapWithFlow(apiService::getAllStories, marvelMapper.storyMapper)
    fun getAllStories() = wrapWithFlow(dao::getAllStories, marvelMapper.storyMapper)

    @JvmName("wrapWithFlowModel")
    private fun <ENTITY, MODEL> wrapWithFlow(
        function: suspend () -> List<ENTITY>?,
        mapper: Mapper<*, ENTITY, MODEL>
    ) = flow {
        emit(State.Loading)
        function().run {
            emit(if (this != null) State.Success(mapper.toModels(this)) else State.Error("No Items!"))
        }
    }.catch {
        emit(State.Error(it.message.toString()))
    }

    @JvmName("wrapWithFlowDto")
    private fun <DTO, ENTITY> wrapWithFlow(
        function: suspend () -> Response<BaseResponse<DTO>>,
        mapper: Mapper<DTO, ENTITY, *>) = flow {
        emit(State.Loading)
        function().run {
            val responseState = body()?.data?.results != null
            if (isSuccessful and (responseState)) {
                body()?.data?.results?.let { emit(State.Success(mapper.toEntities(it))) }
            } else {
                emit(State.Error(message()))
            }
        }
    }.catch {
        emit(State.Error(it.message.toString()))
    }
}