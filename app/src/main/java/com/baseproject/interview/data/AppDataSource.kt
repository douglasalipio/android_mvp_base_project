package com.baseproject.interview.data

import com.baseproject.interview.data.feature.product.ProductDTO
import io.reactivex.Flowable


interface AppDataSource {

    fun requestData(): Flowable<ProductDTO>
}