package com.baseproject.interview.feature.product

data class Product(var categories: List<Category>)

data class Category(
    var tag: String,
    var products: List<Product>
)

data class Item(
    var id: Int,
    var price: String,
    var title: String,
    var size: String,
    var imageUrl: String
)