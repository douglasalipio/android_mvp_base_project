package com.baseproject.interview.feature.product.util

import com.baseproject.interview.feature.product.SubItem
import com.baseproject.interview.feature.product.view.ProductGroup
import com.baseproject.interview.feature.product.view.ProductItem

fun List<SubItem>.mapToProductGroup(clickProductDetail: (String) -> Unit): ProductGroup {
    val productItems = mutableListOf<ProductItem>()
    forEach { subItem -> productItems.add(ProductItem(subItem, clickProductDetail)) }
    return ProductGroup(productItems)
}