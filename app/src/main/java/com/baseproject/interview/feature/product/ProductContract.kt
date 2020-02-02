package com.baseproject.interview.feature.product

import com.baseproject.interview.feature.productdetail.ProductDetail
import com.baseproject.interview.feature.productdetail.ProductDetailInteractor
import com.baseproject.interview.foundation.BasePresenter
import com.baseproject.interview.foundation.BaseView
import com.baseproject.interview.foundation.BaseInteractor
import com.xwray.groupie.Section

interface ProductContract {

    interface View : BaseView<Presenter> {

        fun showProducts(section: Section)
        fun showDataError()
        fun setUpGridList(totalItems: Int, data: Product)
        fun showProductDetail(productDetail: ProductDetail)
    }

    interface Presenter : BasePresenter {
        fun loadData()
        fun mapProductItems(data: Product, clickProductDetail: (String) -> Unit)
        fun loadProductDetail(productId: String)
    }

    interface Interactor : BaseInteractor {
        fun requestData(
            getProductDetailCallback: ProductInteractor.GetProductDetailCallback,
            productId: String
        )

        fun requestData(getProductCallback: ProductInteractor.GetProductCallback)
    }
}