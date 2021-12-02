package com.altaie.marvel.domain.mapper

import com.altaie.marvel.data.remote.response.characters.CharacterDto
import com.altaie.marvel.domain.models.Character

class CharacterMapper : Mapper<CharacterDto, Character> {
    override fun map(input: CharacterDto): Character {
        return Character(
            id = input.id,
            name = input.name,
            description = input.description,
            imgPath = with(input.thumbnail) {
                "${this?.path?.replace("p:", "ps:")}.${this?.extension}"
            },
            modified = input.modified
        )
    }
}