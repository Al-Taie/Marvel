package com.altaie.marvel.domain.mapper

import javax.inject.Inject

class MarvelMapper @Inject constructor(
    val characterMapper: CharacterMapper,
    val comicMapper: ComicMapper
)