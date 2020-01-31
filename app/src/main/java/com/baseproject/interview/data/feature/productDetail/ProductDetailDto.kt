package com.baseproject.interview.data.feature.productDetail

import com.google.gson.annotations.SerializedName

data class ProductDetailDto(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("price")
    var price: String? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("imageUrl")
    var imageUrl: String? = null,
    @SerializedName("description")
    var description: String? = null,
    @SerializedName("allergyInformation")
    var allergyInformation: String? = null
)
