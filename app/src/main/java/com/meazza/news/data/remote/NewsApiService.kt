package com.meazza.news.data.remote

import com.meazza.news.BuildConfig.API_KEY
import com.meazza.news.data.remote.response.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NewsApiService {

    @Headers("X-Api-Key: $API_KEY")
    @GET("top-headlines?country=us&pageSize=100")
    suspend fun getBreakingNews(): Response<NewsResponse>

    @Headers("X-Api-Key: $API_KEY")
    @GET("everything")
    suspend fun searchNews(
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ): Response<NewsResponse>
}