package com.leothos.rssfeed.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.leothos.rssfeed.R
import com.leothos.rssfeed.model.rss.ItemsItem
import com.leothos.rssfeed.ui.adapter.RssFeedAdapter

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

    }
}
