package com.leothos.rssfeed.ui.fragment


import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.leothos.rssfeed.R
import com.leothos.rssfeed.ui.view_model.RssArticleViewModel
import com.leothos.rssfeed.utils.jsInjection2
import kotlinx.android.synthetic.main.fragment_web_view.*


class WebViewFragment : Fragment() {

    private lateinit var webView: WebView
    private lateinit var sharedViewModel: RssArticleViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_web_view, container, false)
        setHasOptionsMenu(true)

        /**
         * Retrieve data shared with the fragment and display a web view within the fragment
         * */
        activity?.let {
            sharedViewModel = ViewModelProviders.of(it).get(RssArticleViewModel::class.java)
            sharedViewModel.getArticleLink().observe(this, Observer { url ->
                webView = view.findViewById(R.id.web_view)


                configureToolBar(url)
                configureSwipeRefreshLayout()

                webView.webViewClient = object : WebViewClient() {

                    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                        Log.d("Tag", "shouldOverrideUrlLoading")
                        return super.shouldOverrideUrlLoading(view, request)
                    }

                    /**
                     * A progressbar is set n order to tell the user the page is loading
                     * */
                    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                        web_view_progressBar.visibility = View.VISIBLE
                        Log.d("Tag", "onPageStarted")
                    }

                    /**
                     * When the page has finished to load the progress bar disappear
                     * */
                    override fun onPageFinished(view: WebView?, url: String?) {
                        Log.d("Tag", "onPageFinished")
                        view?.loadUrl(jsInjection2())
                        web_view_progressBar.visibility = View.GONE
                    }

                }
                webView.settings.loadsImagesAutomatically = true
                webView.loadUrl(url)
            })
        }
        return view
    }

    //**********
    // Toolbar
    //**********

    private fun configureToolBar(url: String) {
        (activity as AppCompatActivity).setSupportActionBar(web_view_toolbar)
        (activity as AppCompatActivity).title = url
    }

    /**
     * Handle the setEnableHome process by getting back to the previous view
     * */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                activity?.supportFragmentManager?.popBackStack()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    // todo fix it
    private fun configureSwipeRefreshLayout() {
        web_view_swipe_layout.setOnRefreshListener { this.getViewModel() }
    }

    private fun getViewModel() {
        sharedViewModel = ViewModelProviders.of(this).get(RssArticleViewModel::class.java)
    }
}
