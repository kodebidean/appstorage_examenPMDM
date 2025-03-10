package com.kodeleku.appstorage_examen.ui.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.kodeleku.appstorage_examen.R
import com.kodeleku.appstorage_examen.databinding.ActivityMainBinding
import com.kodeleku.appstorage_examen.ui.adapter.ArticleAdapter
import com.kodeleku.appstorage_examen.ui.viewmodel.ArticleViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: ArticleViewModel by viewModels()
    private lateinit var articleAdapter: ArticleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar) // Configura la Toolbar

        setupRecyclerView()
        observeArticles()

        // Cargar categoría por defecto (Electrónica)
        viewModel.loadArticles("electronics")
    }

    private fun setupRecyclerView() {
        articleAdapter = ArticleAdapter { article ->
            // Código para abrir DetailActivity
        }
        binding.rvArticles.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = articleAdapter
        }
    }

    private fun observeArticles() {
        viewModel.articles.observe(this) { articles ->
            articleAdapter.submitList(articles)
        }

        viewModel.isLoading.observe(this) { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.drawer_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.nav_electronics -> {
                viewModel.loadArticles("electronics")
                binding.toolbar.title = "Electrónica"
                true
            }
            R.id.nav_jewelery -> {
                viewModel.loadArticles("jewelery")
                binding.toolbar.title = "Joyería"
                true
            }
            R.id.nav_men_clothing -> {
                viewModel.loadArticles("men's clothing")
                binding.toolbar.title = "Ropa Hombre"
                true
            }
            R.id.nav_women_clothing -> {
                viewModel.loadArticles("women's clothing")
                binding.toolbar.title = "Ropa Mujer"
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}

