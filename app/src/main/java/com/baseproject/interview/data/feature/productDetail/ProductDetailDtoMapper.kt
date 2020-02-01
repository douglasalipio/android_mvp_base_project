package com.baseproject.interview.data.feature.productDetail

import com.baseproject.interview.feature.product.Category
import com.baseproject.interview.feature.product.Product
import com.baseproject.interview.feature.product.SubItem
import com.baseproject.interview.feature.productdetail.ProductDetail
import com.baseproject.interview.util.Mapper


class ProductDetailDtoMapper : Mapper<ProductDetailDto, ProductDetail> {

    override fun map(from: ProductDetailDto) = ProductDetail(
        id = from.id,
        price = from.price,
        title = from.title,
        imageUrl = from.imageUrl,
        description = from.description,
        allergyInformation = from.allergyInformation
    )
}
