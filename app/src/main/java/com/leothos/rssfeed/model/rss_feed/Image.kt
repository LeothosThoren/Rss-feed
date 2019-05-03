package com.leothos.rssfeed.model.rss_feed

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root


@Root(name = "image", strict = false)
data class Image(

    @Element(name = "url")
    val url: String? = null
)