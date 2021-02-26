package com.meazza.news.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.meazza.news.business.domain.Article
import com.meazza.news.databinding.LayoutArticleBinding
import com.meazza.news.ui.adapters.ArticleAdapter.ArticleHolder

object ArticleAdapter : ListAdapter<Article, ArticleHolder>(ArticleDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ArticleHolder(
        LayoutArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ArticleHolder, position: Int) {
        holder.itemBinding.run {
            article = currentList[position]
            executePendingBindings()
        }
    }

    class ArticleHolder(val itemBinding: LayoutArticleBinding) :
        RecyclerView.ViewHolder(itemBinding.root)
}