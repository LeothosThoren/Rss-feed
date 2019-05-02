package com.leothos.rssfeed.base

import androidx.lifecycle.ViewModel
import com.leothos.rssfeed.injection.NetworkModule
import com.leothos.rssfeed.injection.component.DaggerViewModelInjector
import com.leothos.rssfeed.injection.component.ViewModelInjector
import com.leothos.rssfeed.ui.view_model.RssFeedListViewModel

abstract class BaseViewModel : ViewModel() {
    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }


    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is RssFeedListViewModel -> injector.inject(this)
        }
    }
}