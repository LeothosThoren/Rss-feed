package com.leothos.rssfeed.network

import com.leothos.rssfeed.model.rss.RssFeed
import io.reactivex.Observable
import retrofit2.http.GET

/**
 *
 * The interface which provides methods to get result of webservices
 */
interface RssFeedApi {
    /**
     * Get the list of the pots from the Rss feed
     */

    @GET("api.json?rss_url=https://www.jeuxactu.com/rss/news.rss")
    fun getRssFeeds(): Observable<RssFeed>
}