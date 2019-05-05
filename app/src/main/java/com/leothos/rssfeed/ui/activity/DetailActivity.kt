package com.leothos.rssfeed.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.leothos.rssfeed.R
import com.leothos.rssfeed.model.rss.ItemsItem
import com.leothos.rssfeed.ui.adapter.RssFeedAdapter
import com.leothos.rssfeed.ui.fragment.DetailFragment
import com.leothos.rssfeed.ui.fragment.WebViewFragment
import com.leothos.rssfeed.ui.view_model.RssArticleViewModel
import com.leothos.rssfeed.utils.EXTRA_INTENT_ITEM
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        configureFragmentContent(DetailFragment())

    }

    private fun configureFragmentContent(frag: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.detail_container, frag)
            .commit()
    }
}
