package com.baseproject.douglas.data.feature.product

import com.baseproject.douglas.feature.product.data.Category
import com.baseproject.douglas.feature.product.data.Product
import com.baseproject.douglas.feature.product.data.SubItem
import com.baseproject.douglas.util.Mapper


class ProductDtoMapper : Mapper<ProductDto, Product> {

    override fun map(from: ProductDto) =
        Product(categories = from.clusters.mapCategories())

    private fun List<Cluster>.mapCategories() =
        map {
            Category(
                tag = it.tag,
                subItems = it.items.mapSubItems()
            )
        }

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
