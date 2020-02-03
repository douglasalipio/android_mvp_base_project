package com.baseproject.douglas.data

import com.baseproject.douglas.data.feature.product.ProductDto
import com.baseproject.douglas.data.feature.productDetail.ProductDetailDto
import io.reactivex.Flowable


interface AppDataSource {

    fun requestProducts(): Flowable<ProductDto>

    fun requestProductDetailById(productId: String) : Flowable<List<ProductDetailDto>>
}