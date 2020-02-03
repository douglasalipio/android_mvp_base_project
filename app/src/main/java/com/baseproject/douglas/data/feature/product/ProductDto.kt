package com.baseproject.douglas.data.feature.product

import com.google.gson.annotations.SerializedName


data class ProductDto(
    @SerializedName("clusters")
    var clusters: List<Cluster>
)

data class Item(
    @SerializedName("id")
    var id: Int,
    @SerializedName("price")
    var price: String,
    @SerializedName("title")
    var title: String,
    @SerializedName("size")
    var size: String,
    @SerializedName("imageUrl")
    var imageUrl: String
)

data class Cluster(
    @SerializedName("tag")
    var tag: String,
    @SerializedName("items")
    var items: List<Item>
)

