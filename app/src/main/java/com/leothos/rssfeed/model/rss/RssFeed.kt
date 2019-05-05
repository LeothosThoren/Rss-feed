package com.leothos.rssfeed.model.rss

import javax.annotation.Generated
import com.squareup.moshi.Json

@Generated("com.robohorse.robopojogenerator")
data class RssFeed(

    @Json(name="feed")
	val feed: Feed? = null,

    @Json(name="items")
	val items: List<ArticleItem?>? = null,

    @Json(name="status")
	val status: String? = null
)