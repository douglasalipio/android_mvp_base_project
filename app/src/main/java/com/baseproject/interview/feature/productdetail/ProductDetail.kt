package com.baseproject.interview.feature.productdetail

data class ProductDetail(
    var id: Int,
    var price: String,
    var title: String,
    var imageUrl: String,
    var description: String,
    var allergyInformation: String
)