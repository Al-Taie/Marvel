package com.altaie.marvel.domain.mapper

interface Mapper<I, O> {
    fun map(input: I) : O
}