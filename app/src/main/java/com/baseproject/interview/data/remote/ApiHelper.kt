package com.baseproject.interview.data.remote

import com.baseproject.interview.data.feature.product.ProductDTO
import io.reactivex.Flowable
import retrofit2.http.GET

const val BASE_URL = "https://my-json-server.typicode.com"

interface ApiHelper {

    @GET("/ocadotechnology/mobile-challenge/products")
    fun getData(): Flowable<ProductDTO>
}