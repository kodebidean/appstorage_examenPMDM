package com.kodeleku.appstorage_examen.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kodeleku.appstorage_examen.databinding.ActivityDetailBinding
import com.kodeleku.appstorage_examen.model.Article
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        loadArticleDetails()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }

    private fun loadArticleDetails() {
        val article = intent.getParcelableExtra<Article>("ARTICLE")
        article?.let {
            binding.tvTitle.text = it.title
            binding.tvPrice.text = "€${it.price}"
            binding.tvDescription.text = it.description
            Picasso.get().load(it.image).into(binding.ivArticle)
        }
    }
}
