package com.meazza.news.data.repository.ds.local

import com.meazza.news.business.domain.Article
import com.meazza.news.data.local.dao.ArticlesDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalNewsDSImpl @Inject constructor(
    private val dao: ArticlesDao
) : LocalNewsDS {

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