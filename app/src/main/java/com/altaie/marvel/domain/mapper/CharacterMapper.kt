package com.altaie.marvel.domain.mapper

import com.altaie.marvel.data.local.entities.CharacterEntity
import com.altaie.marvel.data.remote.response.characters.CharacterDto
import com.altaie.marvel.domain.models.Character

class CharacterMapper : Mapper<CharacterDto, CharacterEntity, Character> {
    override fun toEntity(input: CharacterDto): CharacterEntity {
        return with(input) {
            CharacterEntity(
                id = id,
                name = name,
                description = description,
                imgUrl = with(thumbnail) {
                    "${this?.path?.replace("p:", "ps:")}.${this?.extension}"
                },
                modified = modified
            )
        }
    }

    override fun toModel(input: CharacterEntity): Character {
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