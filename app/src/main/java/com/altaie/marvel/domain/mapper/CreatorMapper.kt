package com.altaie.marvel.domain.mapper

import com.altaie.marvel.data.local.entities.CreatorEntity
import com.altaie.marvel.data.remote.response.creators.CreatorDto
import com.altaie.marvel.domain.models.Creator

class CreatorMapper : Mapper<CreatorDto, CreatorEntity, Creator> {
    override fun toEntity(input: CreatorDto): CreatorEntity {
        return with(input) {
            CreatorEntity(
                id = id,
                name = fullName,
                imgUrl = with(thumbnail) {
                    "${this?.path?.replace("p:", "ps:")}.${this?.extension}"
                },
                modified = modified
            )
        }
    }

    override fun toModel(input: CreatorEntity): Creator {
        return with(input) {
            Creator(
                id = id,
                name = name,
                imgUrl = imgUrl,
                modified = modified
            )
        }
    }
}