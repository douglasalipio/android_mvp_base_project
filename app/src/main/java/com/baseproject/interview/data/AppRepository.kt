package com.baseproject.interview.data

import com.baseproject.interview.data.remote.RemoteDataSource
import javax.inject.Inject


class AppRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) : AppDataSource {

    override fun requestProducts() = remoteDataSource.requestProducts()

    override fun requestProductDetailById(productId: String) = remoteDataSource.requestProductDetailById(productId)
}