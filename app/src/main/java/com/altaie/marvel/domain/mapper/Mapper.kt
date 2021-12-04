package com.altaie.marvel.domain.mapper

interface Mapper<DTO, ENTITY, MODEL> {
    fun toEntity(input: DTO) : ENTITY
    fun toModel(input: ENTITY) : MODEL

    fun toEntities(dtoList: List<DTO>) = dtoList.map(::toEntity)
    fun toModels(entitiesList: List<ENTITY>) = entitiesList.map(::toModel)

}