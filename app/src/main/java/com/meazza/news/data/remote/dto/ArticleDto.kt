package com.meazza.news.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.meazza.news.business.domain.Article

data class ArticleDto(
    @SerializedName("author")
    val author: String?,
    @SerializedName("content")
    val content: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("publishedAt")
    val publishedAt: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("urlToImage")
    val urlToImage: String?
) {
    companion object {
        fun fromArticle(article: Article) = ArticleDto(
            article.author,
            article.content,
            article.description,
            article.publishedAt,
            article.title,
            article.url,
            article.urlToImage
        )
    }

    fun toArticle() = Article(author, content, description, publishedAt, title, url, urlToImage)
}