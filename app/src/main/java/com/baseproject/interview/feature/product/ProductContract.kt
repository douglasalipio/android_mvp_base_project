package com.baseproject.interview.feature.product

import com.baseproject.interview.foundation.BasePresenter
import com.baseproject.interview.foundation.BaseView
import com.baseproject.interview.data.feature.product.ProductDTO
import com.baseproject.interview.foundation.BaseInteractor

interface ProductContract {

    interface View : BaseView<Presenter> {

        fun showData(data: ProductDTO)
        fun showDataError()
    }

    interface Presenter : BasePresenter {
        fun loadData()
    }

    interface Interactor : BaseInteractor {

        fun requestData(getProductCallback: ProductInteractor.GetFeatureCallback)
    }
}