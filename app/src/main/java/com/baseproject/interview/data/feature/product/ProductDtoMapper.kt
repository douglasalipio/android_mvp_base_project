package com.baseproject.interview.data.feature.product

import com.baseproject.interview.feature.product.Category
import com.baseproject.interview.feature.product.Product
import com.baseproject.interview.feature.product.SubItem
import com.baseproject.interview.util.Mapper


class ProductDtoMapper : Mapper<ProductDto, Product> {

    override fun map(from: ProductDto) = Product(categories = from.clusters.mapCategories())

    private fun List<Cluster>.mapCategories() =
        map { Category(tag = it.tag, subItems = it.items.mapSubItems()) }

    private fun List<Item>.mapSubItems() =
        map {
            SubItem(
                id = it.id,
                price = it.price,
                title = it.title,
                size = it.size,
                imageUrl = it.imageUrl
            )
        }
}
