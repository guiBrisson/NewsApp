package me.brisson.newsapp.domain.model

enum class ArticleSortOption(val value: String) {
    RELEVANCY("relevancy"),
    POPULARITY("popularity"),
    PUBLISHED_AT("publishedAt")
}