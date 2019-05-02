package com.leothos.rssfeed.model.rss_feed

import com.google.gson.annotations.SerializedName

data class Channel(

	@field:SerializedName("copyright")
	val copyright: String? = null,

	@field:SerializedName("item")
	val item: List<Item?>? = null,

	@field:SerializedName("docs")
	val docs: String? = null,

	@field:SerializedName("lastBuildDate")
	val lastBuildDate: String? = null,

	@field:SerializedName("link")
	val link: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("language")
	val language: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("category")
	val category: String? = null,

	@field:SerializedName("managingEditor")
	val managingEditor: String? = null,

	@field:SerializedName("webMaster")
	val webMaster: String? = null,

	@field:SerializedName("ttl")
	val ttl: String? = null
)