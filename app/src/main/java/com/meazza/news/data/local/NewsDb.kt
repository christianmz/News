package com.meazza.news.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.meazza.news.data.local.dao.ArticlesDao
import com.meazza.news.data.local.entity.ArticleEntity

@Database(entities = [ArticleEntity::class], version = 1, exportSchema = false)
abstract class NewsDb : RoomDatabase() {

    abstract fun articlesDao(): ArticlesDao
}