package com.meazza.news.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.meazza.news.business.domain.Article
import com.meazza.news.data.util.Constants.TABLE_NAME_ARTICLES

@Entity(tableName = TABLE_NAME_ARTICLES)
data class ArticleEntity(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val title: String,
    @PrimaryKey
    val url: String,
    val urlToImage: String,
    var isBookmarked: Boolean = false
) {
    companion object {
        fun fromArticle(article: Article) = ArticleEntity(
            article.author!!,
            article.content!!,
            article.description!!,
            article.publishedAt!!,
            article.title!!,
            article.url!!,
            article.urlToImage!!
        )
    }

    fun toArticle() = Article(author, content, description, publishedAt, title, url, urlToImage)
}