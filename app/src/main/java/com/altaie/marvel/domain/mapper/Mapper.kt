package com.altaie.marvel.domain.mapper

interface Mapper<DTO, ENT, OBJ> {
    fun toEntity(input: DTO) : ENT
    fun toObject(input: ENT) : OBJ
}