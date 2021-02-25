package com.meazza.news.business.repository

import com.meazza.news.business.domain.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun getNews(): Flow<List<Article>>
    suspend fun getBookmarks(): Flow<List<Article>>
    suspend fun saveArticle(article: Article)
    suspend fun deleteArticle(article: Article)
}