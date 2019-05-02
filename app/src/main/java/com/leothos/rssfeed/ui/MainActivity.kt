package com.leothos.rssfeed.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.leothos.rssfeed.R
import com.leothos.rssfeed.databinding.ActivityMainBinding
import com.leothos.rssfeed.ui.view_model.RssFeedListViewModel

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
        binding.rssFeedList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        viewModel = ViewModelProviders.of(this).get(RssFeedListViewModel::class.java)

        /**
         * Observe the value of errorMessage in this Activity to display the SnackBar when it is not null,
         * and hide it when the value is null
         * */

        viewModel.errorMessage.observe(this, Observer { errorMessage ->
            if (errorMessage != null) showError(errorMessage) else hideError()
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
