package com.meazza.news.di

import android.content.Context
import androidx.room.Room
import com.meazza.news.data.local.NewsDb
import com.meazza.news.data.local.dao.ArticlesDao
import com.meazza.news.data.util.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object DatabaseModule {

    @ActivityRetainedScoped
    @Provides
    fun providesNewsDb(@ApplicationContext context: Context): NewsDb {
        return Room.databaseBuilder(context, NewsDb::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration().build()
    }

    @ActivityRetainedScoped
    @Provides
    fun providesArticlesDao(db: NewsDb): ArticlesDao {
        return db.articlesDao()
    }
}