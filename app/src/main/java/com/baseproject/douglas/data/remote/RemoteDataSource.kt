package com.baseproject.douglas.data.remote

import com.baseproject.douglas.data.AppDataSource

class RemoteDataSource(private val apiHelper: ApiHelper) : AppDataSource {

    override fun requestProducts() = apiHelper.getData()

    override fun requestProductDetailById(productId: String)  = apiHelper.getProductDetail(productId)
}