package com.leothos.rssfeed.model

import com.leothos.rssfeed.model.rss_feed.Channel
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "rss", strict = false)
data class Rss(

    @Element(name = "channel")
    val channel: Channel? = null,

    @Element(name = "_version")
    val version: String? = null
)