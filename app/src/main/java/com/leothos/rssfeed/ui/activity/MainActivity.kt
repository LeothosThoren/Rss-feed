package com.leothos.rssfeed.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.leothos.rssfeed.R
import com.leothos.rssfeed.databinding.ActivityMainBinding
import com.leothos.rssfeed.model.rss.ItemsItem
import com.leothos.rssfeed.ui.adapter.RssFeedAdapter
import com.leothos.rssfeed.ui.view_model.RssFeedListViewModel
import com.leothos.rssfeed.utils.EXTRA_INTENT_ITEM

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: RssFeedListViewModel
    private var errorSnackbar: Snackbar? = null

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /**
         * Set the content view thanks the data binding
         * */

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Configuration of the recycler view
        binding.rssFeedList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        viewModel = ViewModelProviders.of(this).get(RssFeedListViewModel::class.java)

        /**
         * Observe the value of errorMessage in this Activity to display the SnackBar when it is not null,
         * and hide it when the value is null
         * */

        viewModel.errorMessage.observe(this, Observer { errorMessage ->
            if (errorMessage != null) showError(errorMessage) else hideError()
        })

        /**
         * Perform the click thanks to a listener on each item of the list to open the detail activity
         * */
        viewModel.rssFeedAdapter.setOnItemClickListener(object : RssFeedAdapter.OnItemClickListener{
            override fun onClick(view: View, data: ItemsItem) {
                Toast.makeText(applicationContext, data.title, Toast.LENGTH_SHORT).show()
                val intent = Intent(applicationContext, DetailActivity::class.java)
                intent.putExtra(EXTRA_INTENT_ITEM, data)
                startActivity(intent)
            }
        })

        binding.viewModel = viewModel

    }

    /**
     * Show a SnackBar in cas of internet error
     * @param errorMessage value which come from the viewModel
     * */
    private fun showError(@StringRes errorMessage: Int) {
        errorSnackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.setAction(R.string.retry, viewModel.errorClickListener)
        errorSnackbar?.show()
    }

    /**
     * Hide the snack bar if the api call is a success
     * */
    private fun hideError() {
        errorSnackbar?.dismiss()
    }
}
