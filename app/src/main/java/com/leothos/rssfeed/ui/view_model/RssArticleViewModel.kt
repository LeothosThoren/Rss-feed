package com.leothos.rssfeed.ui.view_model

import androidx.lifecycle.MutableLiveData
import com.leothos.rssfeed.base.BaseViewModel
import com.leothos.rssfeed.model.Rss
import com.leothos.rssfeed.model.rss_feed.Item

class RssArticleViewModel : BaseViewModel() {

    private val rssArticleTitle = MutableLiveData<String>()
    private val rssArticlePubDate = MutableLiveData<String>()
    private val rssChannelTitle = MutableLiveData<String>()
    private val rssArticleDescription = MutableLiveData<String>()
    private val rssArticleImageUrl = MutableLiveData<String>()
    private val rssArticleLinkUrl = MutableLiveData<String>()

    fun bind(rssFeed: Rss) {
//        rssChannelTitle.value = rssFeed.channel?.title
        rssArticleTitle.value = rssFeed.channel?.item?.get(0)?.title
        rssArticlePubDate.value = rssFeed.channel?.item?.get(0)?.pubDate
        rssArticleDescription.value = rssFeed.channel?.item?.get(0)?.description
        rssArticleImageUrl.value = rssFeed.channel?.item?.get(0)?.image?.url
        rssArticleLinkUrl.value = rssFeed.channel?.item?.get(0)?.link
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