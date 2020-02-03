package com.baseproject.douglas.feature.product


import com.baseproject.douglas.data.AppDataSource
import com.baseproject.douglas.data.feature.product.ProductDtoMapper
import com.baseproject.douglas.data.feature.productDetail.ProductDetailDtoMapper
import com.baseproject.douglas.feature.product.data.Product
import com.baseproject.douglas.feature.product.data.ProductDetail
import com.baseproject.douglas.util.io
import com.baseproject.douglas.util.ui
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class ProductInteractor @Inject constructor(
    private val appRepository: AppDataSource,
    private val productMapper: ProductDtoMapper,
    private val productDetailMapper: ProductDetailDtoMapper
) :
    ProductContract.Interactor {

    private val compositeDisposable = CompositeDisposable()

    override fun requestProducts(getProductCallback: GetProductCallback) {
        compositeDisposable.add(
            appRepository.requestProducts()
                .subscribeOn(io())
                .observeOn(ui())
                .doOnError { getProductCallback.onDataNotAvailable(it.message.orEmpty()) }
                .subscribe { getProductCallback.onProductLoaded(productMapper.map(it)) }
        )
    }

    override fun requestProductDetail(
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

    interface GetProductCallback {

        fun onProductLoaded(data: Product)

        fun onDataNotAvailable(strError: String)
    }

    interface GetProductDetailCallback {

        fun onProductDetailLoaded(data: List<ProductDetail>)

        fun onDataNotAvailable(strError: String)
    }

}

