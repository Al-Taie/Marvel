package com.altaie.marvel.domain.mapper

import com.altaie.marvel.data.local.entities.CharacterEntity
import com.altaie.marvel.data.local.entities.ComicEntity
import com.altaie.marvel.data.remote.response.characters.CharacterDto
import com.altaie.marvel.data.remote.response.comics.ComicDto
import com.altaie.marvel.domain.models.Character
import com.altaie.marvel.domain.models.Comic

class ComicMapper : Mapper<ComicDto, ComicEntity, Comic> {
    override fun toEntity(input: ComicDto): ComicEntity {
        return with(input) {
            ComicEntity(
                id = id,
                title = title,
                description = description,
                imgUrl = with(thumbnail) {
                    "${this?.path?.replace("p:", "ps:")}.${this?.extension}"
                },
                modified = modified
            )
        }
    }

    override fun toModel(input: ComicEntity): Comic {
        return with(input) {
            Comic(
                id = id,
                title = title,
                description = description,
                imgUrl = imgUrl,
                modified = modified
            )
        }
    }
}