package com.baseproject.interview.data

import com.baseproject.interview.data.feature.product.ProductDto
import io.reactivex.Flowable


interface AppDataSource {

    fun requestData(): Flowable<ProductDto>
}