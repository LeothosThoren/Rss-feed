package com.leothos.rssfeed.ui.view_model

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.leothos.rssfeed.base.BaseViewModel
import com.leothos.rssfeed.network.RssFeedApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RssFeedListViewModel : BaseViewModel() {
    @Inject
    lateinit var rssFeedApi: RssFeedApi

    private lateinit var subscription: Disposable

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()

    init {
        loadRssFeed()
    }

    private fun loadRssFeed() {
        subscription = rssFeedApi.getRssFeeds()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveRssFeedListStart() }
            .doOnTerminate { onRetrieveRssFeedListFinish() }
            .subscribe(
                { onRetrieveRssFeedListSuccess() },
                { onRetrieveRssFeedListError() }
            )
    }

    /**Add a MutableLiveData to the view that will be able to observe in order to update
     * the visibility of the ProgressBar we will show while retrieving the data from the API.
     * */

    private fun onRetrieveRssFeedListStart() {
        loadingVisibility.value = View.VISIBLE
    }

    private fun onRetrieveRssFeedListFinish() {
        loadingVisibility.value = View.GONE
    }

    /**
     *
     *
     * */

    private fun onRetrieveRssFeedListSuccess() {

    }

    private fun onRetrieveRssFeedListError() {

    }


    /**
     * To dispose subscription when the viewModel is no longer used and will be destroyed
     */

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }
}