package com.kodeleku.appstorage_examen.ui.adapter


import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.kodeleku.appstorage_examen.R
import com.kodeleku.appstorage_examen.model.Article
import com.kodeleku.appstorage_examen.ui.view.DetailActivity

class ArticleAdapter(private val onClick: (Article) -> Unit) :
    ListAdapter<Article, ArticleViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = getItem(position)
        holder.bind(article) {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("ARTICLE", article)
            holder.itemView.context.startActivity(intent)
        }
    }


    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Article>() {
            override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean =
                oldItem == newItem
        }
    }
}