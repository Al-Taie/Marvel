package com.altaie.marvel.domain

import com.altaie.marvel.data.local.MarvelDatabase
import com.altaie.marvel.data.local.entities.CharacterEntity
import com.altaie.marvel.data.local.entities.ComicEntity
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

    suspend fun insertAllCharacters(characters: List<CharacterEntity>) = dao.insertCharacters(characters)
    suspend fun insertAllComics(comics: List<ComicEntity>) = dao.insertComics(comics)

    fun getAllCharactersDto() = wrapWithFlow(apiService::getAllCharacters, marvelMapper.characterMapper)
    fun getAllCharacters() = wrapWithFlow(dao::getAllCharacters, marvelMapper.characterMapper)

    fun getAllComicsDto() = wrapWithFlow(apiService::getAllComics, marvelMapper.comicMapper)
    fun getAllComics() = wrapWithFlow(dao::getAllComics, marvelMapper.comicMapper)


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
    private fun <DTO, ENTITY> wrapWithFlow(function: suspend () -> Response<BaseResponse<DTO>>,
                                           mapper: Mapper<DTO, ENTITY, *>) =
        flow {
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