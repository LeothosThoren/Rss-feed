package com.leothos.rssfeed.ui.fragment


import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.leothos.rssfeed.R
import com.leothos.rssfeed.ui.view_model.RssArticleViewModel
import com.leothos.rssfeed.utils.jsInjection
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


        /**
         * Retrieve data shared with the fragment and display a web view within the fragment
         * */
        activity?.let {
            sharedViewModel = ViewModelProviders.of(it).get(RssArticleViewModel::class.java)
            sharedViewModel.getArticleLink().observe(this, Observer { url ->
                configureWebView(view, url)
            })
        }

        return view
    }

    private fun configureWebView(v: View, url: String) {
        webView = v.findViewById(R.id.web_view)
        webView.webViewClient = object : WebViewClient() {

            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                Log.d("Tag", "shouldOverrideUrlLoading")
                return super.shouldOverrideUrlLoading(view, request)
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                web_view_progressBar.visibility = View.VISIBLE
                Log.d("Tag", "onPageStarted")
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                Log.d("Tag", "onPageFinished")
                view?.loadUrl(jsInjection2())
                web_view_progressBar.visibility = View.GONE
            }

        }
        webView.loadUrl(url)
    }
}
