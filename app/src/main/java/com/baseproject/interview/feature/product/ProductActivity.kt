package com.baseproject.interview.feature.product

import android.os.Bundle
import android.util.Log
import com.baseproject.interview.R
import com.baseproject.interview.data.feature.product.ProductDto

import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class ProductActivity : DaggerAppCompatActivity(),
    ProductContract.View {

    @Inject
    internal lateinit var productPresenter: ProductContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        productPresenter.takeView(this)
        productPresenter.loadData()
    }

    override fun showData(data: ProductDto) {
        Log.e("test", data.toString())
    }

    override fun showDataError() {
        Log.e("test", "feature error.")
    }
}
