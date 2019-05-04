package com.leothos.rssfeed.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.leothos.rssfeed.R
import com.leothos.rssfeed.databinding.ItemRssFeedBinding
import com.leothos.rssfeed.model.rss.ItemsItem
import com.leothos.rssfeed.ui.view_model.RssArticleViewModel


class RssFeedAdapter : RecyclerView.Adapter<RssFeedAdapter.ViewHolder>() {

    private lateinit var rssFeedList: List<ItemsItem>
    lateinit var listener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        setOnItemClickListener(listener)
        val binding: ItemRssFeedBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_rss_feed, parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return if (::rssFeedList.isInitialized) rssFeedList.size else 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val rssFeedData = rssFeedList[position]
        holder.bind(rssFeedData)
        holder.itemView.setOnClickListener { listener.onClick(it, rssFeedData) }
    }

    fun updateRssList(article: List<ItemsItem>) {
        this.rssFeedList = article
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onClick(view: View, data: ItemsItem)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    /**
     * ViewHolder class to hold and bind items
     * */
    class ViewHolder(
        private val binding: ItemRssFeedBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private val viewModel = RssArticleViewModel()

        fun bind(rssFeed: ItemsItem) {
            viewModel.bind(rssFeed)
            binding.viewModel = viewModel
        }
    }
}
