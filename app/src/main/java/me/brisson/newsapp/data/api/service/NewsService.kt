package me.brisson.newsapp.data.api.service

import com.skydoves.sandwich.ApiResponse
import me.brisson.newsapp.data.api.dto.ResponseDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface NewsService {

    @GET("v2/everything?q={query}")
    fun getEverything(@Path("query") query: String): ApiResponse<ResponseDTO>

    @GET("v2/top-headlines/sources")
    fun getSources(): ApiResponse<ResponseDTO>
}