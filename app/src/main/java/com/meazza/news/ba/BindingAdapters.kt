package com.meazza.news.ba

import android.view.View
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.meazza.news.business.domain.Article
import com.meazza.news.parcelize.ArticleParcelize
import com.meazza.news.ui.adapters.ArticleAdapter
import com.meazza.news.ui.article.ArticleFragmentDirections
import com.meazza.news.util.loadUrl
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("android:setVisibility")
    fun setVisibility(view: View, isVisible: Boolean) {
        when (isVisible) {
            true -> view.visibility = View.VISIBLE
            false -> view.visibility = View.GONE
        }
    }

    @JvmStatic
    @BindingAdapter("android:setImage")
    fun setImage(imageView: ImageView, url: String?) {
        imageView.loadUrl(url)
    }

    @JvmStatic
    @BindingAdapter("android:setCustomAdapter")
    fun setCustomAdapter(recyclerView: RecyclerView, articleAdapter: ArticleAdapter) {
        recyclerView.run {
            setHasFixedSize(true)
            adapter = articleAdapter
            itemAnimator = SlideInUpAnimator().apply {
                addDuration = 300
            }
        }
    }

    @JvmStatic
    @BindingAdapter("android:onArticleClick")
    fun onArticleClick(card: CardView, article: Article) {
        card.setOnClickListener {
            val action =
                ArticleFragmentDirections.actionArticle(ArticleParcelize.fromArticle(article))
            card.findNavController().navigate(action)
        }
    }
}