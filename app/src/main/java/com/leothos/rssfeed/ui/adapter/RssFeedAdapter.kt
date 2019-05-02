package com.leothos.rssfeed.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.leothos.rssfeed.R
import com.leothos.rssfeed.databinding.ItemRssFeedBinding
import com.leothos.rssfeed.model.Rss
import com.leothos.rssfeed.model.rss_feed.Item
import com.leothos.rssfeed.ui.view_model.RssArticleViewModel

class RssFeedAdapter : RecyclerView.Adapter<RssFeedAdapter.ViewHolder>() {

    private lateinit var rssFeedList: List<Rss>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RssFeedAdapter.ViewHolder {
        val binding: ItemRssFeedBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_rss_feed, parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return if (::rssFeedList.isInitialized) rssFeedList.size else 0
    }

    override fun onBindViewHolder(holder: RssFeedAdapter.ViewHolder, position: Int) {
        holder.bind(rssFeedList[position])
    }

    fun updateRssList(rssItem: List<Rss>) {
        this.rssFeedList = rssItem
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemRssFeedBinding) : RecyclerView.ViewHolder(binding.root) {
        private val viewModel = RssArticleViewModel()

        fun bind(rssFeed: Rss) {
            viewModel.bind(rssFeed)
            binding.viewModel = viewModel
        }
    }
}