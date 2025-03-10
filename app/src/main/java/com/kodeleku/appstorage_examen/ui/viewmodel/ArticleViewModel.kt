package com.kodeleku.appstorage_examen.ui.viewmodel

import androidx.lifecycle.*
import com.kodeleku.appstorage_examen.data.repository.ArticleRepository
import com.kodeleku.appstorage_examen.model.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(private val repository: ArticleRepository) : ViewModel() {
    private val _articles = MutableLiveData<List<Article>>()
    val articles: LiveData<List<Article>> get() = _articles

    fun loadArticles(category: String) {
        viewModelScope.launch {
            val response = repository.getArticlesByCategory(category)
            if (response.isSuccessful) {
                _articles.postValue(response.body())
            }
        }
    }
}
