package com.meazza.news.parcelize

import android.os.Parcelable
import com.meazza.news.business.domain.Article
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArticleParcelize(
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val title: String?,
    val url: String?,
    val urlToImage: String?,
    var isBookmarked: Boolean = false
) : Parcelable {

    companion object {
        fun fromArticle(article: Article) = ArticleParcelize(
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
