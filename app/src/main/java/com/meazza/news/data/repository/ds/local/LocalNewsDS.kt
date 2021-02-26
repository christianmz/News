package com.meazza.news.data.repository.ds.local

import com.meazza.news.business.domain.Article
import com.meazza.news.business.util.Resource
import kotlinx.coroutines.flow.Flow

interface LocalNewsDS {
    suspend fun getBookmarks(): Flow<Resource<List<Article>>>
    suspend fun saveArticle(article: Article)
    suspend fun deleteArticle(article: Article)
}