package com.kodeleku.appstorage_examen.data.remote

import com.kodeleku.appstorage_examen.model.Article
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ArticlesApiService {
    @GET("products/category/electronics")
    suspend fun getElectronics(): Response<List<Article>>

    @GET("products/category/jewelery")
    suspend fun getJewelery(): Response<List<Article>>

    @GET("products/category/men's clothing")
    suspend fun getMensClothing(): Response<List<Article>>

    @GET("products/category/women's clothing")
    suspend fun getWomensClothing(): Response<List<Article>>

    @GET("products/{id}")
    suspend fun getArticleDetail(@Path("id") id: Int): Response<Article>
}