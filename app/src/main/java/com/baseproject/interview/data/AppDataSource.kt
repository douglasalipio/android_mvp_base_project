package com.baseproject.interview.data

import com.baseproject.interview.data.feature.product.ProductDto
import com.baseproject.interview.data.feature.productDetail.ProductDetailDto
import io.reactivex.Flowable
import io.reactivex.Single


interface AppDataSource {

    fun requestProducts(): Flowable<ProductDto>

    fun requestProductDetailById(productId: String) : Flowable<List<ProductDetailDto>>
}