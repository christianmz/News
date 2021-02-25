package com.meazza.news.data.repository.ds.local

import com.meazza.news.business.domain.Article
import kotlinx.coroutines.flow.Flow

interface LocalNewsDS {
    suspend fun getBookmarks(): Flow<List<Article>>
    suspend fun saveArticle(article: Article)
    suspend fun deleteArticle(article: Article)
}