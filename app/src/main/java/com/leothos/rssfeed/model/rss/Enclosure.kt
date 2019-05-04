package com.leothos.rssfeed.model.rss

import javax.annotation.Generated
import com.squareup.moshi.Json

@Generated("com.robohorse.robopojogenerator")
data class Enclosure(

	@Json(name="link")
	val link: String? = null,

	@Json(name="length")
	val length: Int? = null,

	@Json(name="type")
	val type: String? = null
)