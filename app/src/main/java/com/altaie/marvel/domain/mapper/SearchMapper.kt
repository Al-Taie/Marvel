package com.altaie.marvel.domain.mapper

import com.altaie.marvel.data.local.entities.SearchEntity
import com.altaie.marvel.data.remote.response.characters.CharacterDto
import com.altaie.marvel.domain.models.Character

class SearchMapper : Mapper<CharacterDto, SearchEntity, Character> {
    override fun toEntity(input: CharacterDto): SearchEntity {
        return with(input) {
            SearchEntity(
                id = id,
                name = name,
                description = description,
                imgUrl = thumbnail?.run { "$path.$extension" },
                modified = modified
            )
        }
    }

    override fun toModel(input: SearchEntity): Character {
        return with(input) {
            Character(
                id = id,
                name = name,
                description = description,
                imgUrl = imgUrl,
                modified = modified
            )
        }
    }
}