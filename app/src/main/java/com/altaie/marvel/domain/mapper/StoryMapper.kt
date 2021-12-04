package com.altaie.marvel.domain.mapper

import com.altaie.marvel.data.local.entities.StoryEntity
import com.altaie.marvel.data.remote.response.stories.StoryDto
import com.altaie.marvel.domain.models.Story

class StoryMapper : Mapper<StoryDto, StoryEntity, Story> {
    override fun toEntity(input: StoryDto): StoryEntity {
        return with(input) {
            StoryEntity(
                id = id,
                title = title,
                type = type,
                description = description,
                imgUrl = thumbnail?.run { "$path.$extension" },
                modified = modified
            )
        }
    }

    override fun toModel(input: StoryEntity): Story {
        return with(input) {
            Story(
                id = id,
                title = title,
                type = type,
                description = description,
                imgUrl = imgUrl,
                modified = modified
            )
        }
    }
}