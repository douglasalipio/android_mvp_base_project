package com.baseproject.interview.feature.product


import com.baseproject.interview.data.AppDataSource
import com.baseproject.interview.data.feature.product.ProductDto
import com.baseproject.interview.data.feature.product.ProductDtoMapper
import com.baseproject.interview.util.io
import com.baseproject.interview.util.ui
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class ProductInteractor @Inject constructor(
    private val appRepository: AppDataSource,
    private val mapper: ProductDtoMapper
) :
    ProductContract.Interactor {

    private val compositeDisposable = CompositeDisposable()

    interface GetProductCallback {

        fun onProductLoaded(data: Product)

        fun onDataNotAvailable(strError: String)
    }

    override fun requestData(getProductCallback: GetProductCallback) {
        compositeDisposable.add(
            appRepository.requestProducts()
                .subscribeOn(io())
                .observeOn(ui())
                .doOnError { onError(getProductCallback, it.message.orEmpty()) }
                .subscribe { onSuccess(getProductCallback, it) }
        )
    }

    override fun dispose() = compositeDisposable.dispose()

    private fun onError(getProductCallback: GetProductCallback, strError: String) =
        getProductCallback.onDataNotAvailable(strError)

    private fun onSuccess(getProductCallback: GetProductCallback, productDto: ProductDto) =
        getProductCallback.onProductLoaded(mapper.map(productDto))
}

