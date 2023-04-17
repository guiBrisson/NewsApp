package me.brisson.newsapp.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.brisson.newsapp.data.api.repository.NewsRepositoryImpl
import me.brisson.newsapp.data.api.service.NewsService
import me.brisson.newsapp.domain.repository.NewsRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun providesNewsRepository(newsService: NewsService) : NewsRepository =
        NewsRepositoryImpl(newsService)
}