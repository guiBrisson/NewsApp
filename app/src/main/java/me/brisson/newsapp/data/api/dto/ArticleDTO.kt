package me.brisson.newsapp.data.api.dto

import me.brisson.newsapp.domain.model.Article

data class ArticleDTO(
    val source: ArticleSource?,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?,
)

data class ArticleSource (
    val id: String?,
    val name: String?,
)

fun ArticleDTO.toArticle() = Article(
    sourceId = source?.id,
    sourceName = source?.name,
    author = author,
    title = title,
    description = description,
    url = url,
    urlToImage = urlToImage,
    publishedAt = publishedAt,
    content = content
)
