package com.meazza.news.data.repository.ds.remote

import com.meazza.news.business.domain.Article
import com.meazza.news.business.util.Resource
import com.meazza.news.data.remote.NewsApiService
import com.meazza.news.data.util.toArticlesList
import timber.log.Timber
import javax.inject.Inject

class RemoteNewsDSImpl @Inject constructor(
    private val service: NewsApiService
) : RemoteNewsDS {

    override suspend fun getNews(): Resource<List<Article>> {
        val response = service.getBreakingNews()
        val result = response.body()
        return try {
            if (response.isSuccessful && result != null) {
                Resource.Success(result.articles.toArticlesList())
            } else {
                Resource.Error(response.message())
            }
        } catch (e: Exception) {
            Timber.d(e)
            Resource.Error("${e.message}")
        }
    }

    override suspend fun searchNews(query: String, page: Int, pageSize: Int) {
        service.searchNews(query, page, pageSize)
    }
}