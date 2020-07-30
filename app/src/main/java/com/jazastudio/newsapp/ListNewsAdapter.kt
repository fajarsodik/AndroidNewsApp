package com.jazastudio.newsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_list.view.*

class ListNewsAdapter(
    private val listNews: List<NewsData>,
    private val listenerAdapter: (NewsData) -> Unit
) : RecyclerView.Adapter<ListNewsAdapter.ListNewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListNewsViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ListNewsViewHolder(view)
    }

    override fun getItemCount(): Int = listNews.size

    override fun onBindViewHolder(holder: ListNewsViewHolder, position: Int) {
        holder.bindItem(listNews[position], listenerAdapter)
    }

    inner class ListNewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(newsData: NewsData, listenerAdapter: (NewsData) -> Unit) {
            itemView.tv_header.text = newsData.title
            itemView.tv_detail.text = newsData.description
            Glide.with(itemView.context)
                .load(newsData.urlToImage)
                .into(itemView.iv_cover)
            itemView.setOnClickListener {
                listenerAdapter(newsData)
            }
        }
    }

}