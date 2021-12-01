package com.altaie.marvel.data.remote

import com.altaie.marvel.data.remote.response.base.BaseResponse
import com.altaie.marvel.data.remote.response.characters.CharacterDto
import com.altaie.marvel.data.remote.response.comics.ComicsDto
import com.altaie.marvel.data.remote.response.creators.CreatorDto
import com.altaie.marvel.data.remote.response.events.EventDto
import com.altaie.marvel.data.remote.response.series.SeriesDto
import com.altaie.marvel.data.remote.response.stories.StoryDto
import retrofit2.Response
import retrofit2.http.GET

interface MarvelApiService {
    @GET("characters")
    suspend fun getAllCharacters() : Response<BaseResponse<CharacterDto>>

    @GET("comics")
    suspend fun getAllComics() : Response<BaseResponse<ComicsDto>>

    @GET("creators")
    suspend fun getAllCreators() : Response<BaseResponse<CreatorDto>>

    @GET("events")
    suspend fun getAllEvents() : Response<BaseResponse<EventDto>>

    @GET("series")
    suspend fun getAllSeries() : Response<BaseResponse<SeriesDto>>

    @GET("stories")
    suspend fun getAllStories() : Response<BaseResponse<StoryDto>>
}