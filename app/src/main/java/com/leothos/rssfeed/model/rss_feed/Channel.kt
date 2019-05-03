package com.leothos.rssfeed.model.rss_feed

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root


@Root(name = "channel", strict= false)
data class Channel(

    @Element(name = "copyright")
    val copyright: String? = null,

    @ElementList(name = "item")
    val item: List<Item?>? = null,

    @Element(name = "lastBuildDate")
    val lastBuildDate: String? = null,

    @Element(name = "link")
    val link: String? = null,

    @Element(name = "title")
    val title: String? = null

)