package com.kodeleku.appstorage_examen.model

data class Article(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String
)