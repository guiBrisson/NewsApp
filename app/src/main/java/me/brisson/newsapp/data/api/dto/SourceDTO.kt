package me.brisson.newsapp.data.api.dto

import me.brisson.newsapp.domain.model.Source

data class SourceDTO(
    val id: String?,
    val name: String?,
    val description: String?,
    val url: String?,
    val category: String?,
    val language: String?,
    val country: String?,
)

fun SourceDTO.toSource() = Source(
    id = id,
    name = name,
    description = description,
    url = url,
    category = category,
    language = language,
    country = country
)
