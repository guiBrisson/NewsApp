package me.brisson.newsapp.data.api.repository

import com.skydoves.sandwich.message
import com.skydoves.sandwich.onFailure
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import me.brisson.newsapp.data.api.dto.toArticle
import me.brisson.newsapp.data.api.dto.toSource
import me.brisson.newsapp.data.api.service.NewsService
import me.brisson.newsapp.domain.model.Article
import me.brisson.newsapp.domain.model.ArticleSortOption
import me.brisson.newsapp.domain.model.Category
import me.brisson.newsapp.domain.model.CountryCode
import me.brisson.newsapp.domain.model.Source
import me.brisson.newsapp.domain.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsService: NewsService
) : NewsRepository {

    override fun getEverything(
        query: String?,
        sortBy: ArticleSortOption?,
        sources: List<String>?,
        dateFrom: String?,
        dateTo: String?,
        onError: (String?) -> Unit
    ): Flow<List<Article>> = flow {
        val response = newsService.getEverything(
            query,
            sortBy?.value,
            sources?.joinToString(", "),
            dateFrom,
            dateTo
        )

        response.suspendOnSuccess {
            data.articles?.map { it.toArticle() }?.let { emit(it) }
        }.onFailure {
            onError(message())
        }
    }

    override fun getTopHeadlines(
        query: String?,
        countryCode: CountryCode?,
        category: Category?,
        sources: List<String>?,
        onError: (String?) -> Unit
    ): Flow<List<Article>> = flow {
        val response = newsService.getTopHeadlines(
            query = query,
            countryCode = countryCode?.code,
            category = category?.value,
            sources = sources?.joinToString(", "),
        )

        response.suspendOnSuccess {
            data.articles?.map { it.toArticle() }?.let { emit(it) }
        }.onFailure {
            onError(message())
        }
    }

    override fun getAllSources(
        countryCode: CountryCode?,
        category: Category?,
        onError: (String?) -> Unit
    ): Flow<List<Source>> = flow {
        val response =
            newsService.getSources(countryCode = countryCode?.code, category = category?.value)

        response.suspendOnSuccess {
            data.sources?.map { it.toSource() }?.let { emit(it) }
        }.onFailure {
            onError(message())
        }
    }

}
