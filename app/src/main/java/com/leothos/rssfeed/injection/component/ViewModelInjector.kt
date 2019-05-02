package com.leothos.rssfeed.injection.component

import com.leothos.rssfeed.injection.NetworkModule
import com.leothos.rssfeed.ui.view_model.RssFeedListViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {
    /**
     * Injects required dependencies into the specified rssFeedListViewModel.
     * @param rssFeedListViewModel rssFeedListViewModel in which to inject the dependencies
     */
    fun inject(rssFeedListViewModel: RssFeedListViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}