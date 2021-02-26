package com.meazza.news.data.repository.ds.remote

import com.meazza.news.business.domain.Article
import com.meazza.news.business.util.Resource

interface RemoteNewsDS {
    suspend fun getNews(): Resource<List<Article>>
}