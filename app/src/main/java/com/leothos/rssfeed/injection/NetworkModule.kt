package com.leothos.rssfeed.injection

import com.leothos.rssfeed.network.RssFeedApi
import com.leothos.rssfeed.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
object NetworkModule {
    /**
     * Provides the RssFeed service implementation.
     * @param retrofit the Retrofit object used to instantiate the service
     * @return the RssFeed service implementation.
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRssFeedApi(retrofit: Retrofit) : RssFeedApi {
        return retrofit.create(RssFeedApi::class.java)
    }

    /**
     * Provides the Retrofit object.
     * @return the Retrofit object
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
    }

}