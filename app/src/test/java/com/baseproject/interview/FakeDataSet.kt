package com.baseproject.interview

import com.baseproject.interview.data.feature.product.Cluster
import com.baseproject.interview.data.feature.product.Item
import com.baseproject.interview.data.feature.product.ProductDto
import com.baseproject.interview.data.feature.productDetail.ProductDetailDto
import com.baseproject.interview.feature.product.Category
import com.baseproject.interview.feature.product.Product
import com.baseproject.interview.feature.product.SubItem
import com.baseproject.interview.feature.productdetail.ProductDetail


fun mockProducts() = Product(mockCategories())
fun mockProductDto() = ProductDto(mockCluster())

fun mockCategories() = listOf(
    Category(
        tag = "tag1",
        subItems = mockSubItems()
    )
)

fun mockCluster() = listOf(
    Cluster(
        tag = "tag1",
        items = mockItem()
    )
)

fun mockSubItems() = listOf(
    SubItem(
        id = 123,
        price = "12,00",
        title = "Title 1",
        size = "Small",
        imageUrl = "url1"
    )
)

fun mockItem() = listOf(
    Item(
        id = 123,
        price = "12,00",
        title = "Title 1",
        size = "Small",
        imageUrl = "url1"
    )
)

fun mockProductDetail() = ProductDetail(
    id = "10",
    price = "€20",
    title = "Bananas Pacovan",
    imageUrl = "url_img",
    description = "Organic. Suitable for vegetarians",
    allergyInformation = "May contain traces of Sesame Seeds"
)

fun mockProductDetailDto() = ProductDetailDto(
    id = "10",
    price = "€20",
    title = "Bananas Pacovan",
    imageUrl = "url_img",
    description = "Organic. Suitable for vegetarians",
    allergyInformation = "May contain traces of Sesame Seeds"
)
