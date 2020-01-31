package com.baseproject.interview.feature.product


import com.baseproject.interview.data.feature.product.ProductDTO
import com.baseproject.interview.di.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class ProductPresenter @Inject constructor(private val interactor: ProductContract.Interactor) :
    ProductContract.Presenter {

    private var view: ProductContract.View? = null

    override fun <T> takeView(view: T) {
        this.view = view as ProductContract.View
    }

    override fun loadData() {
        view?.let {
            interactor.requestData(object : ProductInteractor.GetFeatureCallback {
                override fun onFeatureLoaded(data: ProductDTO) {
                    it.showData(data)
                }

                override fun onDataNotAvailable(strError: String) {
                    it.showDataError()
                }
            })
        }
    }

    override fun dropView() {
        view = null
    }
}