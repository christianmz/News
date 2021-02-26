package com.meazza.news.ui.news

import com.meazza.news.business.domain.Article

sealed class NewsEvents {
    class Success(val articles: List<Article>) : NewsEvents()
    class Failure(val errorText: String) : NewsEvents()
    object Loading : NewsEvents()
}