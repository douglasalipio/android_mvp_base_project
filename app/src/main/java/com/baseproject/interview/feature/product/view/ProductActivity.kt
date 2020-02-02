package com.baseproject.interview.feature.product.view

import android.os.Bundle
import android.util.Log
import com.baseproject.interview.R
import com.baseproject.interview.feature.product.Product
import com.baseproject.interview.feature.product.ProductContract
import com.baseproject.interview.feature.productdetail.ProductDetail
import com.baseproject.interview.util.initGridLayout
import com.baseproject.interview.util.showFullPhotoDialog

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

    override fun showProductDetail(data: ProductDetail) = this.showFullPhotoDialog(data)

    override fun showProducts(section: Section) = adapter.add(section)

    private fun onProductDetailClicked(productId: String) = presenter.loadProductDetail(productId)

    override fun showDataError() {
        Log.e("test", "feature error.")
    }
}
