package me.brisson.newsapp.domain.repository

import kotlinx.coroutines.flow.Flow
import me.brisson.newsapp.domain.model.Article
import me.brisson.newsapp.domain.model.ArticleSortOption
import me.brisson.newsapp.domain.model.Category
import me.brisson.newsapp.domain.model.CountryCode
import me.brisson.newsapp.domain.model.Source

interface NewsRepository {
    fun getEverything(
        query: String? = null,
        sortBy: ArticleSortOption? = null,
        sources: List<String>? = null,
        dateFrom: String? = null,
        dateTo: String? = null,
        onError: (String?) -> Unit,
    ): Flow<List<Article>>

    fun getTopHeadlines(
        query: String? = null,
        countryCode: CountryCode? = CountryCode.BR,
        category: Category? = null,
        sources: List<String>? = null,
        onError: (String?) -> Unit,
    ): Flow<List<Article>>

    fun getAllSources(
        countryCode: CountryCode? = CountryCode.BR,
        category: Category? = null,
        onError: (String?) -> Unit,
    ): Flow<List<Source>>
}
