package com.leothos.rssfeed.model

import com.google.gson.annotations.SerializedName
import com.leothos.rssfeed.model.rss_feed.Channel

data class Rss(

    @field:SerializedName("channel")
    val channel: Channel? = null,

    @field:SerializedName("_version")
    val version: String? = null
)