package com.leothos.rssfeed.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.leothos.rssfeed.R
import com.leothos.rssfeed.databinding.FragmentDetailBinding
import com.leothos.rssfeed.model.rss.ArticleItem
import com.leothos.rssfeed.ui.view_model.RssArticleViewModel
import com.leothos.rssfeed.utils.EXTRA_INTENT_ITEM


class DetailFragment : Fragment() {

    private lateinit var fragBinding: FragmentDetailBinding
    private lateinit var sharedViewModel: RssArticleViewModel
    private var detailData: ArticleItem? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        val view = fragBinding.root

        // Get the data from the item list
        detailData = activity?.intent?.getParcelableExtra(EXTRA_INTENT_ITEM)

        // Use of the viewModel to bind the data with the view thanks to databinding
        activity?.let {
            sharedViewModel = ViewModelProviders.of(it).get(RssArticleViewModel::class.java).apply {
                getArticleTitle().postValue(detailData?.title)
                getArticlePubDate().postValue(detailData?.pubDate)
                getArticleImage().postValue(detailData?.enclosure?.link)
                getArticleDescription().postValue(detailData?.description)
                getArticleLink().postValue(detailData?.link)
            }

        }

        // Action
        fragBinding.webViewButton.setOnClickListener { launchWebViewFragment() }

        fragBinding.viewModel = sharedViewModel
        return view
    }


    /**
     * This method launch a new fragment within the activity.
     * It displays a web view with uri content
     * */
    private fun launchWebViewFragment() {
        fragmentManager?.beginTransaction()
            ?.addToBackStack("WebViewFragment")
            ?.add(android.R.id.content, WebViewFragment())
            ?.commit()
    }

}
