package com.leothos.rssfeed.model.rss

import javax.annotation.Generated
import com.squareup.moshi.Json

@Generated("com.robohorse.robopojogenerator")
data class ItemsItem(

	@Json(name="thumbnail")
	val thumbnail: String? = null,

	@Json(name="enclosure")
	val enclosure: Enclosure? = null,

	@Json(name="author")
	val author: String? = null,

	@Json(name="link")
	val link: String? = null,

	@Json(name="guid")
	val guid: String? = null,

	@Json(name="description")
	val description: String? = null,

	@Json(name="categories")
	val categories: List<Any?>? = null,

	@Json(name="title")
	val title: String? = null,

	@Json(name="pubDate")
	val pubDate: String? = null,

	@Json(name="content")
	val content: String? = null
)