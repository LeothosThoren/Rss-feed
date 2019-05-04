package com.leothos.rssfeed.model.rss

import javax.annotation.Generated
import com.squareup.moshi.Json

@Generated("com.robohorse.robopojogenerator")
data class Feed(

	@Json(name="image")
	val image: String? = null,

	@Json(name="author")
	val author: String? = null,

	@Json(name="link")
	val link: String? = null,

	@Json(name="description")
	val description: String? = null,

	@Json(name="title")
	val title: String? = null,

	@Json(name="url")
	val url: String? = null
)