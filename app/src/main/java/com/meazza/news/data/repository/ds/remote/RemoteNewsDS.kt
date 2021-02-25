package com.meazza.news.data.repository.ds.remote

import com.meazza.news.business.domain.Article
import kotlinx.coroutines.flow.Flow

interface RemoteNewsDS {
    fun getNews(): Flow<List<Article>>
}