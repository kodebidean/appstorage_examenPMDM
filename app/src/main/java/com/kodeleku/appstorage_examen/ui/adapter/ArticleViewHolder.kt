package com.kodeleku.appstorage_examen.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.kodeleku.appstorage_examen.databinding.ItemArticleBinding
import com.kodeleku.appstorage_examen.model.Article
import com.squareup.picasso.Picasso

class ArticleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemArticleBinding.bind(view)

    fun bind(article: Article, onClick: (Article) -> Unit) {
        binding.tvTitle.text = article.title
        binding.tvPrice.text = "€${article.price}"
        Picasso.get().load(article.image).into(binding.ivArticle)

        itemView.setOnClickListener { onClick(article) }
    }
}