package me.brisson.newsapp.data.api.dto

data class ResponseDTO(
    val status: String?,
    val totalResults: Int?,
    val articles: List<ArticleDTO>?,
    val sources: List<SourceDTO>?,

    // Error
    val code: String?,
    val message: String?,
)
