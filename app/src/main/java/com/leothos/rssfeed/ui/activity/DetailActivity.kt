package com.leothos.rssfeed.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.leothos.rssfeed.R
import com.leothos.rssfeed.ui.fragment.DetailFragment
import com.leothos.rssfeed.utils.extensions.toast
import kotlinx.android.synthetic.main.activity_detail.*

/**
 * This page display the detail of an item selected in the previous activity
 * */
class DetailActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Configuration
        configureFragmentContent(DetailFragment())
        detail_return_button_arrow.setOnClickListener(this)
        detail_book_mark_button.setOnClickListener(this)
        detail_share_button.setOnClickListener(this)
        detail_settings_button.setOnClickListener(this)

    }

    /**
     * @param frag the fragment needed
     * Configure and open  a fragment thanks supportFragment manager
     * */
    private fun configureFragmentContent(frag: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.detail_container, frag)
            .commit()
    }

    // Action
    /**
     * Series of click button from the custom toolbar in order to upgrade the application
     * */
    override fun onClick(v: View?) {
        val id = v?.id
        when (id) {
            R.id.detail_return_button_arrow -> finish()
            R.id.detail_book_mark_button -> toast("Bookmark button pressed")
            R.id.detail_share_button -> toast("Shared button pressed")
            R.id.detail_settings_button -> toast("Settings button pressed")
        }
    }
}
