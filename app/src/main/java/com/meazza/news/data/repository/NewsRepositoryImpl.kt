package com.meazza.news.data.repository

import com.meazza.news.business.domain.Article
import com.meazza.news.business.repository.NewsRepository
import com.meazza.news.business.util.Resource
import com.meazza.news.data.repository.ds.local.LocalNewsDS
import com.meazza.news.data.repository.ds.remote.RemoteNewsDS
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val localDS: LocalNewsDS,
    private val remoteDS: RemoteNewsDS
) : NewsRepository {

    override suspend fun getNews(): Resource<List<Article>> {
        return remoteDS.getNews()
    }

    override suspend fun searchNews(query: String, page: Int, pageSize: Int) {
        remoteDS.searchNews(query, page, pageSize)
    }
}