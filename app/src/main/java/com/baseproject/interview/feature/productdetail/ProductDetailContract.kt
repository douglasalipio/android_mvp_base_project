package com.baseproject.interview.feature.productdetail

import com.baseproject.interview.foundation.BasePresenter
import com.baseproject.interview.foundation.BaseView
import com.baseproject.interview.data.feature.product.ProductDto
import com.baseproject.interview.foundation.BaseInteractor
import com.xwray.groupie.Section

interface ProductDetailContract {

    interface View : BaseView<Presenter> {
        fun showDataError()
        fun showProductDetail(productDetail : ProductDetail)
    }

    interface Presenter : BasePresenter {
        fun loadProductDetail(productId: String)
    }

    interface Interactor : BaseInteractor {
        fun requestData(getProductCallback: ProductDetailInteractor.GetProductDetailCallback, productId : String)
    }
}