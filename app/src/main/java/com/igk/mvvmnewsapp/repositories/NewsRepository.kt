package com.androiddevs.mvvmnewsapp.repositories

import com.androiddevs.mvvmnewsapp.api.RetrofitInstance
import com.androiddevs.mvvmnewsapp.db.ArticleDatabase

class NewsRepository(val db:ArticleDatabase) {
    suspend fun getBreakingNews(sources:String,pageNumber: Int) =
        RetrofitInstance.newsApi.getBreakingNews(sources,pageNumber)

    suspend fun searchNews(searchQuery:String,pageNumber: Int) =
        RetrofitInstance.newsApi.searchForNews(searchQuery,pageNumber)
}