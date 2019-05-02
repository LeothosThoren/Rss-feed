package com.leothos.rssfeed.model.rss_feed

import com.google.gson.annotations.SerializedName
import com.leothos.rssfeed.model.Rss

data class FeedRss(

	@field:SerializedName("rss")
	val rss: Rss? = null
)