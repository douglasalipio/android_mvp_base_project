package com.baseproject.douglas.feature.product

import com.baseproject.douglas.feature.product.data.Product
import com.baseproject.douglas.feature.product.data.ProductDetail
import com.baseproject.douglas.foundation.BasePresenter
import com.baseproject.douglas.foundation.BaseView
import com.baseproject.douglas.foundation.BaseInteractor
import com.xwray.groupie.Section

interface ProductContract {

    interface View : BaseView<Presenter> {

        fun showProducts(section: Section)
        fun showDataError()
        fun setUpGridList(totalItems: Int, product: Product)
        fun showProductDetail(productDetail: ProductDetail)
    }

    interface Presenter : BasePresenter {
        fun loadData()
        fun mapProductItems(data: Product, clickProductDetail: (String) -> Unit)
        fun loadProductDetail(productId: String)
    }

    interface Interactor : BaseInteractor {
        fun requestProductDetail(
            getProductDetailCallback: ProductInteractor.GetProductDetailCallback,
            productId: String
        )

        fun requestProducts(getProductCallback: ProductInteractor.GetProductCallback)
    }
}