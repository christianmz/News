package com.meazza.news.business.repository

import com.meazza.news.business.domain.Article
import com.meazza.news.business.util.Resource

interface NewsRepository {
    suspend fun getNews(): Resource<List<Article>>
    suspend fun searchNews(query: String, page: Int, pageSize: Int)
}