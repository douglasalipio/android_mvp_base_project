package com.baseproject.douglas.data.remote

import com.baseproject.douglas.data.feature.product.ProductDto
import com.baseproject.douglas.data.feature.productDetail.ProductDetailDto
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://my-json-server.typicode.com"

interface ApiHelper {

    @GET("/ocadotechnology/mobile-challenge/products")
    fun getData(): Flowable<ProductDto>

    @GET("/ocadotechnology/mobile-challenge/product")
    fun getProductDetail(@Query("product_id") productId: String): Flowable<List<ProductDetailDto>>
}