package com.meazza.news.ui.adapters

import androidx.recyclerview.widget.DiffUtil
import com.meazza.news.business.domain.Article

object ArticleDiffUtil : DiffUtil.ItemCallback<Article>() {

    override fun areItemsTheSame(oldItem: Article, newItem: Article) =
        oldItem.url == newItem.url

    override fun areContentsTheSame(oldItem: Article, newItem: Article) =
        oldItem.hashCode() == newItem.hashCode()
}
