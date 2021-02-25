package com.meazza.news.data.repository.ds.remote

import com.meazza.news.business.domain.Article
import com.meazza.news.data.remote.NewsApiService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RemoteNewsDSImpl @Inject constructor(
    private val service: NewsApiService
) : RemoteNewsDS {

    override fun getNews(): Flow<List<Article>> {
        TODO("Not yet implemented")
    }
}