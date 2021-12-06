package com.altaie.marvel.domain.mapper

import com.altaie.marvel.data.local.entities.SeriesEntity
import com.altaie.marvel.data.remote.response.series.SeriesDto
import com.altaie.marvel.domain.models.Series

class SeriesMapper : Mapper<SeriesDto, SeriesEntity, Series> {
    override fun toEntity(input: SeriesDto): SeriesEntity {
        return with(input) {
            SeriesEntity(
                id = id,
                title = title,
                type = type,
                rating = rating,
                startYear = startYear,
                endYear = endYear,
                description = description,
                imgUrl = thumbnail?.run { "$path.$extension" },
                modified = modified
            )
        }
    }

    override fun toModel(input: SeriesEntity): Series {
        return with(input) {
            Series(
                id = id,
                title = title,
                type = type,
                rating = rating,
                startYear = startYear,
                endYear = endYear,
                description = description,
                imgUrl = imgUrl,
                modified = modified
            )
        }
    }
}