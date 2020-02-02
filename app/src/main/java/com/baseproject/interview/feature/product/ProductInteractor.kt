package com.baseproject.interview.feature.product


import com.baseproject.interview.data.AppDataSource
import com.baseproject.interview.data.feature.product.ProductDto
import com.baseproject.interview.data.feature.product.ProductDtoMapper
import com.baseproject.interview.data.feature.productDetail.ProductDetailDto
import com.baseproject.interview.data.feature.productDetail.ProductDetailDtoMapper
import com.baseproject.interview.feature.productdetail.ProductDetail
import com.baseproject.interview.feature.productdetail.ProductDetailInteractor
import com.baseproject.interview.util.io
import com.baseproject.interview.util.ui
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class ProductInteractor @Inject constructor(
    private val appRepository: AppDataSource,
    private val productMapper: ProductDtoMapper,
    private val productDetailMapper: ProductDetailDtoMapper
) :
    ProductContract.Interactor {

    private val compositeDisposable = CompositeDisposable()

    interface GetProductCallback {

        fun onProductLoaded(data: Product)

        fun onDataNotAvailable(strError: String)
    }

    interface GetProductDetailCallback {

        fun onProductDetailLoaded(data: List<ProductDetail>)

        fun onDataNotAvailable(strError: String)
    }

    override fun requestData(getProductCallback: GetProductCallback) {
        compositeDisposable.add(
            appRepository.requestProducts()
                .subscribeOn(io())
                .observeOn(ui())
                .doOnError { getProductCallback.onDataNotAvailable(it.message.orEmpty()) }
                .subscribe { getProductCallback.onProductLoaded(productMapper.map(it)) }
        )
    }

    override fun requestData(
        getProductDetailCallback: GetProductDetailCallback,
        productId: String
    ) {
        compositeDisposable.add(
            appRepository.requestProductDetailById(productId)
                .subscribeOn(io())
                .observeOn(ui())
                .doOnError { getProductDetailCallback.onDataNotAvailable(it.message.orEmpty()) }
                .subscribe {
                    getProductDetailCallback.onProductDetailLoaded(productDetailMapper.map(it))
                }
        )
    }

    override fun dispose() = compositeDisposable.dispose()

}

