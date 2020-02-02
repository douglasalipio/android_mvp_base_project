package com.baseproject.interview.feature.productdetail

import javax.inject.Inject

class ProductDetailPresenter @Inject constructor(private val interactor: ProductDetailContract.Interactor) :
    ProductDetailContract.Presenter {

    private var view: ProductDetailContract.View? = null

    override fun <T> takeView(view: T) {
        this.view = view as ProductDetailContract.View
    }

    override fun loadProductDetail(productId : String) {
        interactor.requestData(object : ProductDetailInteractor.GetProductDetailCallback {

            override fun onProductDetailLoaded(data: ProductDetail) {
                view?.showProductDetail(data)
            }

            override fun onDataNotAvailable(strError: String) {
                view?.showProductDetailError()
            }
        },productId)
    }

    override fun dropView() {
        view = null
    }

}