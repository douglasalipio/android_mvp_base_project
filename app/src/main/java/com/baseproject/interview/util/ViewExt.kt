package com.baseproject.interview.util

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.baseproject.interview.R
import com.baseproject.interview.feature.productdetail.ProductDetail
import com.bumptech.glide.Glide
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.dialog_product_detail.view.*

fun RecyclerView.initGridLayout(
    context: Context,
    groupAdapter: GroupAdapter<GroupieViewHolder>,
    numberColumn: Int
) {

    val gridLayoutManager = GridLayoutManager(context, numberColumn)
    gridLayoutManager.spanSizeLookup = groupAdapter.spanSizeLookup
    this.adapter = groupAdapter
    this.layoutManager = gridLayoutManager
}

fun Context.showFullPhotoDialog(productDetail: ProductDetail) {
    val dialog = MaterialDialog(this)

    dialog.show {
        customView(R.layout.dialog_product_detail)
        Glide.with(context)
            .load(productDetail.imageUrl)
            .placeholder(R.drawable.placeholder)
            .into(view.photoImg)
        cornerRadius(16f)
        view.allergyInformation.text = productDetail.allergyInformation
        view.productDescription.text = productDetail.description
        title(text = productDetail.title)
        positiveButton { this.dismiss() }
    }
}