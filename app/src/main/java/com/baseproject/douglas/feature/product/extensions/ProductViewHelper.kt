package com.baseproject.douglas.feature.product.extensions

import android.app.Activity
import android.content.Context
import android.widget.ImageView
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.baseproject.douglas.R
import com.baseproject.douglas.feature.product.data.ProductDetail
import com.baseproject.douglas.feature.product.data.SubItem
import com.baseproject.douglas.feature.product.view.ProductGroup
import com.baseproject.douglas.feature.product.view.ProductItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.dialog_product_detail.view.*

fun List<SubItem>.mapToProductGroup(clickProductDetail: (String) -> Unit): ProductGroup {
    val productItems = mutableListOf<ProductItem>()
    forEach { subItem -> productItems.add(ProductItem(subItem, clickProductDetail)) }
    return ProductGroup(productItems)
}

fun Activity.showProductDetailDialog(productDetail: ProductDetail) {
    MaterialDialog(this).show {
        customView(R.layout.dialog_product_detail)
        setImage(applicationContext, productDetail.imageUrl, view.photoImg)
        cornerRadius(16f)
        title(text = productDetail.title)
        positiveButton { dismiss() }
        view.allergyInformation.text = productDetail.allergyInformation
        view.productDescription.text = productDetail.description
    }
}

private fun setImage(context: Context, imageUrl: String, photoImg: ImageView) {
    Glide.with(context)
        .load(imageUrl)
        .placeholder(R.drawable.placeholder)
        .into(photoImg)
}