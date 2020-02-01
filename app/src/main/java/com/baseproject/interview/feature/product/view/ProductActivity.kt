package com.baseproject.interview.feature.product.view

import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import com.baseproject.interview.R
import com.baseproject.interview.feature.product.Product
import com.baseproject.interview.feature.product.ProductContract
import com.baseproject.interview.util.ProductDecorator
import com.baseproject.interview.util.SpacesItemDecoration
import com.baseproject.interview.util.initGridLayout

import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Section

import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class ProductActivity : DaggerAppCompatActivity(),
    ProductContract.View {

    @Inject
    internal lateinit var presenter: ProductContract.Presenter
    private val adapter = GroupAdapter<GroupieViewHolder>()
    private val clickProductDetail: (String) -> Unit = this::onProductDetailClicked

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.takeView(this)
        presenter.loadData()
    }

    override fun setUpGridList(totalItems: Int, data: Product) {
        adapter.spanCount = totalItems
        productList.initGridLayout(this, adapter, adapter.spanCount)
        presenter.mapProductItems(data, clickProductDetail)
    }

    override fun showProducts(section: Section) = adapter.add(section)


    override fun showDataError() {
        Log.e("test", "feature error.")
    }

    private fun onProductDetailClicked(productId: String) {

    }
}
