package com.leothos.rssfeed.network

import com.leothos.rssfeed.model.rss.RssFeed
import com.leothos.rssfeed.utils.apiKey
import io.reactivex.Observable
import retrofit2.http.GET

/**
 *
 * The interface which provides methods to get result of webservices
 */
interface RssFeedApi {
    /**
     * Get the list from the Rss feed
     * Using retrofit and RxJava
     */

    @GET("api.json?rss_url=https://www.jeuxactu.com/rss/ja.rss&api_key=$apiKey")
    fun getRssFeeds(): Observable<RssFeed>
}