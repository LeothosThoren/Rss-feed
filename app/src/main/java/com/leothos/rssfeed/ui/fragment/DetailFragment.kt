package com.leothos.rssfeed.ui.fragment


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.leothos.rssfeed.R
import com.leothos.rssfeed.databinding.FragmentDetailBinding
import com.leothos.rssfeed.model.rss.ItemsItem
import com.leothos.rssfeed.ui.view_model.RssArticleViewModel
import com.leothos.rssfeed.utils.EXTRA_INTENT_ITEM


class DetailFragment : Fragment() {

    private lateinit var fragBinding: FragmentDetailBinding
    private lateinit var sharedViewModel: RssArticleViewModel
    private var detailData: ItemsItem? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        val view = fragBinding.root


        detailData = activity?.intent?.getParcelableExtra(EXTRA_INTENT_ITEM)

        activity?.let {
            sharedViewModel = ViewModelProviders.of(it).get(RssArticleViewModel::class.java).apply {
                getArticleTitle().postValue(detailData?.title)
                getArticlePubDate().postValue(detailData?.pubDate)
                getArticleImage().postValue(detailData?.enclosure?.link)
                getArticleDescription().postValue(detailData?.description)
                getArticleLink().postValue(detailData?.link)
            }

        }

        fragBinding.webViewButton.setOnClickListener { launchWebViewFragment() }

        fragBinding.viewModel = sharedViewModel
        return view
    }

    private fun launchWebViewFragment() {
        fragmentManager?.beginTransaction()
            ?.addToBackStack("WebViewFragment")
            ?.hide(DetailFragment())
            ?.add(android.R.id.content, WebViewFragment())
            ?.commit()
    }

}
