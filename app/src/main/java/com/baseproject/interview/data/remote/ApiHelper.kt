package com.baseproject.interview.data.remote

import com.baseproject.interview.data.feature.product.ProductDto
import com.baseproject.interview.data.feature.productDetail.ProductDetailDto
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://my-json-server.typicode.com/ocadotechnology/mobile-challenge"

interface ApiHelper {

    @GET("/products")
    fun getData(): Flowable<ProductDto>

    @GET("/product")
    fun getProductDetail(@Query("product_id") productId: String): Flowable<ProductDetailDto>
}