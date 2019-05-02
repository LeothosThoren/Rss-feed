package com.leothos.rssfeed.model.rss_feed

import com.google.gson.annotations.SerializedName

data class Item(

    @field:SerializedName("image")
    val image: Image? = null,

    @field:SerializedName("link")
    val link: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("guid")
    val guid: String? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("category")
    val category: String? = null,

    @field:SerializedName("pubDate")
    val pubDate: String? = null
)