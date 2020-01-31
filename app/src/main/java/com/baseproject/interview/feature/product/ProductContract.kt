package com.baseproject.interview.feature.product

import com.baseproject.interview.foundation.BasePresenter
import com.baseproject.interview.foundation.BaseView
import com.baseproject.interview.data.feature.product.ProductDto
import com.baseproject.interview.foundation.BaseInteractor
import com.xwray.groupie.Section

interface ProductContract {

    interface View : BaseView<Presenter> {

        fun showData(sections: List<Section>)
        fun showDataError()
        fun setUpGridList(totalItems: Int, data: Product)
    }

    interface Presenter : BasePresenter {
        fun loadData()
        fun mapProductItems(data: Product, clickProductDetail: (String) -> Unit)
    }

    interface Interactor : BaseInteractor {

        fun requestData(getProductCallback: ProductInteractor.GetProductCallback)
    }
}