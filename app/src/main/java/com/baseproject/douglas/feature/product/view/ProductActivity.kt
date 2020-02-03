package com.baseproject.douglas.feature.product.view

import android.os.Bundle
import android.util.Log
import com.baseproject.douglas.R
import com.baseproject.douglas.feature.product.data.Product
import com.baseproject.douglas.feature.product.ProductContract
import com.baseproject.douglas.feature.product.data.ProductDetail
import com.baseproject.douglas.feature.product.extensions.showProductDetailDialog
import com.baseproject.douglas.util.initGridLayout


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

    override fun setUpGridList(totalItems: Int, product: Product) {
        adapter.spanCount = totalItems
        productList.initGridLayout(this, adapter, adapter.spanCount)
        presenter.mapProductItems(product, clickProductDetail)
    }

    override fun showProductDetail(productDetail: ProductDetail) {
        showProductDetailDialog(productDetail)
    }

    override fun showProducts(section: Section) = adapter.add(section)

    private fun onProductDetailClicked(productId: String) = presenter.loadProductDetail(productId)

    override fun showDataError() {
        Log.e("test", "feature error.")
    }
}
