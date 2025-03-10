package com.kodeleku.appstorage_examen.data.repository

import com.kodeleku.appstorage_examen.data.remote.ArticlesApiService
import javax.inject.Inject

class ArticleRepository @Inject constructor(private val api: ArticlesApiService) {
    suspend fun getArticlesByCategory(category: String) =
        when (category) {
            "electronics" -> api.getElectronics()
            "jewelery" -> api.getJewelery()
            "men's clothing" -> api.getMensClothing()
            "women's clothing" -> api.getWomensClothing()
            else -> api.getElectronics()
        }

    suspend fun getArticleDetail(id: Int) = api.getArticleDetail(id)
}
