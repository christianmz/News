package com.meazza.news.data.repository

import com.meazza.news.business.domain.Article
import com.meazza.news.business.repository.NewsRepository
import com.meazza.news.data.repository.ds.local.LocalNewsDS
import com.meazza.news.data.repository.ds.remote.RemoteNewsDS
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val localDS: LocalNewsDS,
    private val remoteDS: RemoteNewsDS
) : NewsRepository {

    override suspend fun getNews(): Flow<List<Article>> {
        TODO("Not yet implemented")
    }

    override suspend fun getBookmarks(): Flow<List<Article>> {
        TODO("Not yet implemented")
    }

    override suspend fun saveArticle(article: Article) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteArticle(article: Article) {
        TODO("Not yet implemented")
    }
}