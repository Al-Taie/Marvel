package com.altaie.marvel.domain.mapper

import com.altaie.marvel.data.local.entities.CreatorEntity
import com.altaie.marvel.data.local.entities.EventEntity
import com.altaie.marvel.data.remote.response.creators.CreatorDto
import com.altaie.marvel.data.remote.response.events.EventDto
import com.altaie.marvel.domain.models.Creator
import com.altaie.marvel.domain.models.Event

class EventMapper : Mapper<EventDto, EventEntity, Event> {
    override fun toEntity(input: EventDto): EventEntity {
        return with(input) {
            EventEntity(
                id = id,
                title = title,
                start = start,
                end = end,
                description = description,
                imgUrl = with(thumbnail) {
                    "${this?.path?.replace("p:", "ps:")}.${this?.extension}"
                },
                modified = modified
            )
        }
    }

    override fun toModel(input: EventEntity): Event {
        return with(input) {
            Event(
                id = id,
                title = title,
                start = start,
                end = end,
                description = description,
                imgUrl = imgUrl,
                modified = modified
            )
        }
    }
}