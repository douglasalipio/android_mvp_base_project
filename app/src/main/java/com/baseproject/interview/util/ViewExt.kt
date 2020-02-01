package com.baseproject.interview.util

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.baseproject.interview.R
import com.bumptech.glide.Glide
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder

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

//fun Context.showFullPhotoDialog(productDetail : Prodc) {
//    val dialog = MaterialDialog(this)
//
//    dialog.show {
//        customView(R.layout.full_photo_view)
//        Glide.with(context).load(url).into(view.fullImage)
//        cornerRadius(16f)
//        title(text = context.getString(R.string.image_dialog_title))
//        positiveButton { this.dismiss() }
//    }
//}