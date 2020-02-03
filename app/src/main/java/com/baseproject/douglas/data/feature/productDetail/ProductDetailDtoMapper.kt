package com.baseproject.douglas.data.feature.productDetail

import com.baseproject.douglas.feature.product.data.ProductDetail
import com.baseproject.douglas.util.Mapper


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
