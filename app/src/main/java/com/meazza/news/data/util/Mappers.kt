package com.meazza.news.data.util

import com.meazza.news.data.remote.dto.ArticleDto

fun List<ArticleDto>.toArticlesList() = map { it.toArticle() }