package com.meazza.news.data.repository.ds.local

import com.meazza.news.data.local.dao.ArticlesDao
import javax.inject.Inject

class LocalNewsDSImpl @Inject constructor(
    private val dao: ArticlesDao
) : LocalNewsDS