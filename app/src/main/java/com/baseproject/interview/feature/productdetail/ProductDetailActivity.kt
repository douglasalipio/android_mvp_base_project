package com.baseproject.interview.feature.productdetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.baseproject.interview.R
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class ProductDetailActivity : DaggerAppCompatActivity(),
    ProductDetailContract.View {

    private val productId by lazy { intent.getStringExtra(EXTRA_ID_PRODUCT).orEmpty() }

    @Inject
    internal lateinit var presenter: ProductDetailContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_product_detail)
        presenter.takeView(this)
        presenter.loadProductDetail(productId)
    }

    override fun showProductDetail(productDetail: ProductDetail) {

    }

    override fun showProductDetailError() {

    }

    companion object {

        const val EXTRA_ID_PRODUCT = "extra-id-product"
        fun start(context: Context, productId: String) {
            val intent = Intent(context, ProductDetailActivity::class.java).apply {
                putExtra(EXTRA_ID_PRODUCT, productId)
            }
            context.startActivity(intent)
        }
    }
}
