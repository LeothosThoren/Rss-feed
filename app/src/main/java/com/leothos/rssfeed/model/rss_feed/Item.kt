package com.leothos.rssfeed.model.rss_feed

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "item", strict = false)
data class Item(

    @Element(name = "image")
    val image: Image? = null,

    @Element(name = "link")
    val link: String? = null,

    @Element(name = "description")
    val description: String? = null,

    @Element(name = "guid")
    val guid: String? = null,

    @Element(name = "title")
    val title: String? = null,

    @Element(name = "category")
    val category: String? = null,

    @Element(name = "pubDate")
    val pubDate: String? = null
)