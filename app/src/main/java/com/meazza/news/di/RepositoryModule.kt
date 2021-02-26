package com.meazza.news.di

import com.meazza.news.business.repository.NewsRepository
import com.meazza.news.data.local.dao.ArticlesDao
import com.meazza.news.data.remote.NewsApiService
import com.meazza.news.data.repository.NewsRepositoryImpl
import com.meazza.news.data.repository.ds.local.LocalNewsDS
import com.meazza.news.data.repository.ds.local.LocalNewsDSImpl
import com.meazza.news.data.repository.ds.remote.RemoteNewsDS
import com.meazza.news.data.repository.ds.remote.RemoteNewsDSImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @ViewModelScoped
    @Provides
    fun providesLocalNewsDS(dao: ArticlesDao): LocalNewsDS {
        return LocalNewsDSImpl(dao)
    }

    @ViewModelScoped
    @Provides
    fun providesRemoteNewsDS(service: NewsApiService): RemoteNewsDS {
        return RemoteNewsDSImpl(service)
    }

    @ViewModelScoped
    @Provides
    fun providesNewsRepository(
        localNewsDS: LocalNewsDS,
        remoteNewsDS: RemoteNewsDS
    ): NewsRepository {
        return NewsRepositoryImpl(localNewsDS, remoteNewsDS)
    }
}