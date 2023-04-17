package me.brisson.newsapp.data.api.service

import com.skydoves.sandwich.ApiResponse
import me.brisson.newsapp.data.api.dto.ResponseDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("everything")
    suspend fun getEverything(
        @Query("q") query: String?,
        @Query("sortBy") sortBy: String?,
        @Query("sources") sources: String?,
        @Query("from") dateFrom: String?,
        @Query("to") dateTo: String?,
    ): ApiResponse<ResponseDTO>

    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("q") query: String?,
        @Query("country") countryCode: String?,
        @Query("category") category: String?,
        @Query("sources") sources: String?,
    ): ApiResponse<ResponseDTO>

    @GET("top-headlines/sources")
    suspend fun getSources(
        @Query("country") countryCode: String?,
        @Query("category") category: String?,
    ): ApiResponse<ResponseDTO>

}
