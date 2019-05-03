package com.leothos.rssfeed.ui.view_model

import androidx.lifecycle.MutableLiveData
import com.leothos.rssfeed.base.BaseViewModel
import com.leothos.rssfeed.model.rss_feed.Item

class RssArticleViewModel : BaseViewModel() {

    private val rssArticleTitle = MutableLiveData<String>()
    private val rssArticlePubDate = MutableLiveData<String>()
    private val rssChannelTitle = MutableLiveData<String>()
    private val rssArticleDescription = MutableLiveData<String>()
    private val rssArticleImageUrl = MutableLiveData<String>()
    private val rssArticleLinkUrl = MutableLiveData<String>()

    fun bind(rssFeed: Item) {
//        rssChannelTitle.value = rssFeed.channel?.title
        rssArticleTitle.value = rssFeed.title
        rssArticlePubDate.value = rssFeed.pubDate
        rssArticleDescription.value = rssFeed.description
        rssArticleImageUrl.value = rssFeed.image?.url
        rssArticleLinkUrl.value = rssFeed.link
    }

    fun getArticleTitle(): MutableLiveData<String> {
        return rssArticleTitle
    }

    fun getArticlePubDate(): MutableLiveData<String> {
        return rssArticlePubDate
    }

    fun getChannelTitle(): MutableLiveData<String> {
        return rssChannelTitle
    }

    fun getArticleDescription(): MutableLiveData<String> {
        return rssArticleDescription
    }

    fun getArticleImage(): MutableLiveData<String> {
        return rssArticleImageUrl
    }

    fun getArticleLink(): MutableLiveData<String> {
        return rssArticleLinkUrl
    }
}