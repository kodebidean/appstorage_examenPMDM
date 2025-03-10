package com.kodeleku.appstorage_examen.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kodeleku.appstorage_examen.data.repository.ArticleRepository
import com.kodeleku.appstorage_examen.model.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(private val repository: ArticleRepository) : ViewModel() {
    private val _articles = MutableLiveData<List<Article>>()
    val articles: LiveData<List<Article>> get() = _articles

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    fun loadArticles(category: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.postValue(true)
            try {
                val response = repository.getArticlesByCategory(category)
                if (response.isSuccessful) {
                    _articles.postValue(response.body())
                }
            } catch (e: Exception) {
                _articles.postValue(emptyList()) // Lista Vacía si hay excepción
            } finally {
                _isLoading.postValue(false) // Fin Carggar
            }
        }
    }
}

