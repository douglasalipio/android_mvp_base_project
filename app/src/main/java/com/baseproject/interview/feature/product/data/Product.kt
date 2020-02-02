package com.baseproject.interview.feature.product.data

data class Product(var categories: List<Category>)

data class Category(
    var tag: String,
    var subItems: List<SubItem>
)

data class SubItem(
    var id: Int,
    var price: String,
    var title: String,
    var size: String,
    var imageUrl: String
)