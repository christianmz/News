package com.meazza.news.ui.news

import androidx.lifecycle.ViewModel
import com.meazza.news.business.repository.NewsRepository
import com.meazza.news.ui.adapters.ArticleAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val repository: NewsRepository
) : ViewModel() {

    val adapter = ArticleAdapter
}