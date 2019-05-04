package com.leothos.rssfeed.ui.view_model

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.leothos.rssfeed.R
import com.leothos.rssfeed.base.BaseViewModel
import com.leothos.rssfeed.model.rss.ItemsItem
import com.leothos.rssfeed.model.rss.RssFeed
import com.leothos.rssfeed.network.RssFeedApi
import com.leothos.rssfeed.ui.adapter.RssFeedAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RssFeedListViewModel : BaseViewModel() {
    @Inject
    lateinit var rssFeedApi: RssFeedApi

    private lateinit var subscription: Disposable
    // val
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage: MutableLiveData<Int> = MutableLiveData()
    val rssFeedTitle: MutableLiveData<String> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadRssFeed() }
    val rssFeedAdapter: RssFeedAdapter = RssFeedAdapter()

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
                // Add result
                { result ->
                    onRetrieveRssFeedListSuccess(result)
                },

                {
                    onRetrieveRssFeedListError()
                }
            )
    }

    /**
     * Add a MutableLiveData to the view that will be able to observe in order to update
     * the visibility of the ProgressBar we will show while retrieving the data from the API.
     * */

    private fun onRetrieveRssFeedListStart() {
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrieveRssFeedListFinish() {
        loadingVisibility.value = View.GONE
    }

    /**
     * Handle the network behavior on success or on error
     *
     * */

    private fun onRetrieveRssFeedListSuccess(rssFeed: RssFeed) {
        Log.d("Debug", "first content = ${rssFeed.items?.size}")
        rssFeedAdapter.updateRssList(rssFeed.items as List<ItemsItem>)
        rssFeedTitle.value = rssFeed.feed?.title
    }

    private fun onRetrieveRssFeedListError() {
        Log.d("Debug", "Error message")
        errorMessage.value = R.string.rss_error
    }


    /**
     * To dispose subscription when the viewModel is no longer used and will be destroyed
     */

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }
}