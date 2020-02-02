package com.baseproject.interview.data.feature.productDetail

import com.baseproject.interview.feature.product.data.ProductDetail
import com.baseproject.interview.util.Mapper


class ProductDetailDtoMapper : Mapper<List<ProductDetailDto>, List<ProductDetail>> {

    override fun map(from: List<ProductDetailDto>) = from.map {
        ProductDetail(
            id = it.id,
            price = it.price,
            title = it.title,
            imageUrl = it.imageUrl,
            description = it.description,
            allergyInformation = it.allergyInformation
        )
    }
}
