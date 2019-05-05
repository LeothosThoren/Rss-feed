package com.leothos.rssfeed.model.rss

import android.os.Parcelable
import javax.annotation.Generated
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class ArticleItem(

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

	@Json(name="title")
	val title: String? = null,

	@Json(name="pubDate")
	val pubDate: String? = null,

	@Json(name="content")
	val content: String? = null
):Parcelable