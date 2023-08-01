package com.androiddevs.mvvmnewsapp.api

import com.androiddevs.mvvmnewsapp.models.NewsResponse
import com.androiddevs.mvvmnewsapp.utils.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsApi {
    @GET("top-headlines")
    suspend fun getBreakingNews(
        @Query("sources") sources: String?,
        @Query("page") pageNumber: Int,
        @Query("apiKey") apiKey: String = API_KEY

    ): Response<NewsResponse>

    @GET("everything")
    suspend fun searchForNews(
        @Query("q") searchQuery: String,
        @Query("page") pageNumber: Int,
        @Query("apiKey") apiKey: String = API_KEY

    ): Response<NewsResponse>
}

