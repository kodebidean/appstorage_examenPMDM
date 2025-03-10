package com.kodeleku.appstorage_examen.data.di

import com.kodeleku.appstorage_examen.data.remote.ArticlesApiService
import com.kodeleku.appstorage_examen.data.repository.ArticleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASE_URL = "https://fakestoreapi.com/"

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideArticlesApiService(retrofit: Retrofit): ArticlesApiService {
        return retrofit.create(ArticlesApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideArticleRepository(apiService: ArticlesApiService): ArticleRepository {
        return ArticleRepository(apiService)
    }
}
