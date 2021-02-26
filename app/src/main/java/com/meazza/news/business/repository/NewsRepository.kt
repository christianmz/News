package com.meazza.news.business.repository

import com.meazza.news.business.domain.Article
import com.meazza.news.business.util.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun getNews(): Resource<List<Article>>
    suspend fun getBookmarks(): Flow<Resource<List<Article>>>
    suspend fun saveArticle(article: Article)
    suspend fun deleteArticle(article: Article)
}