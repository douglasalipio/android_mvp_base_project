package com.baseproject.interview.feature.product


import com.baseproject.interview.data.AppDataSource
import com.baseproject.interview.data.feature.product.ProductDto
import com.baseproject.interview.util.io
import com.baseproject.interview.util.ui
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class ProductInteractor @Inject constructor(private val appRepository: AppDataSource) : ProductContract.Interactor {

    private val compositeDisposable = CompositeDisposable()

    interface GetFeatureCallback {

        fun onFeatureLoaded(data: ProductDto)

        fun onDataNotAvailable(strError: String)
    }

    override fun requestData(getFeatureCallback: GetFeatureCallback) {
        compositeDisposable.add(
            appRepository.requestData()
                .subscribeOn(io())
                .observeOn(ui())
                .doOnError { getFeatureCallback.onDataNotAvailable(it.message ?: "") }
                .subscribe { onNext -> getFeatureCallback.onFeatureLoaded(onNext) }
        )
    }
}

