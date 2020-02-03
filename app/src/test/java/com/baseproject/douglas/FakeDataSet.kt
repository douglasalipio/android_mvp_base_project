package com.baseproject.douglas

import com.baseproject.douglas.data.feature.product.Cluster
import com.baseproject.douglas.data.feature.product.Item
import com.baseproject.douglas.data.feature.product.ProductDto
import com.baseproject.douglas.data.feature.productDetail.ProductDetailDto
import com.baseproject.douglas.feature.product.data.Category
import com.baseproject.douglas.feature.product.data.Product
import com.baseproject.douglas.feature.product.data.SubItem
import com.baseproject.douglas.feature.product.data.ProductDetail


fun mockProducts() =
    Product(mockCategories())
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

fun mockProductDetail() =
    ProductDetail(
        id = "10",
        price = "€20",
        title = "Bananas Pacovan",
        imageUrl = "url_img",
        description = "Organic. Suitable for vegetarians",
        allergyInformation = "May contain traces of Sesame Seeds"
    )

fun mockProductDetails() = listOf(
    ProductDetail(
        id = "10",
        price = "€20",
        title = "Bananas Pacovan",
        imageUrl = "url_img",
        description = "Organic. Suitable for vegetarians",
        allergyInformation = "May contain traces of Sesame Seeds"
    )
)

fun mockProductDetailDto() = ProductDetailDto(
    id = "10",
    price = "€20",
    title = "Bananas Pacovan",
    imageUrl = "url_img",
    description = "Organic. Suitable for vegetarians",
    allergyInformation = "May contain traces of Sesame Seeds"
)
