package com.baseproject.interview.feature.productdetail


import com.baseproject.interview.data.AppDataSource
import com.baseproject.interview.data.feature.product.ProductDto
import com.baseproject.interview.data.feature.product.ProductDtoMapper
import com.baseproject.interview.data.feature.productDetail.ProductDetailDto
import com.baseproject.interview.data.feature.productDetail.ProductDetailDtoMapper
import com.baseproject.interview.util.io
import com.baseproject.interview.util.ui
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class ProductDetailInteractor @Inject constructor(
    private val appRepository: AppDataSource,
    private val mapper: ProductDetailDtoMapper
) :
    ProductDetailContract.Interactor {

    private val compositeDisposable = CompositeDisposable()

    interface GetProductDetailCallback {

        fun onProductDetailLoaded(data: ProductDetail)

        fun onDataNotAvailable(strError: String)
    }

    override fun requestData(getProductCallback: GetProductDetailCallback, productId : String) {
        compositeDisposable.add(
            appRepository.requestProductDetailById(productId)
                .subscribeOn(io())
                .observeOn(ui())
                .doOnError { onError(getProductCallback, it.message.orEmpty()) }
                .subscribe { onSuccess(getProductCallback, it) }
        )
    }

    override fun dispose() = compositeDisposable.dispose()

    private fun onError(getProductCallback: GetProductDetailCallback, strError: String) =
        getProductCallback.onDataNotAvailable(strError)

    private fun onSuccess(getProductCallback: GetProductDetailCallback, data: ProductDetailDto) =
        getProductCallback.onProductDetailLoaded(mapper.map(data))
}

