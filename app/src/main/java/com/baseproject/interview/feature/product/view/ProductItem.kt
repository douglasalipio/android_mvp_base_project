package com.baseproject.interview.feature.product.view

import android.annotation.SuppressLint
import com.baseproject.interview.R
import com.baseproject.interview.feature.product.data.SubItem
import com.bumptech.glide.Glide
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.product_item.view.*


class ProductItem(
    private val subItem: SubItem,
    private val clickListener: (String) -> Unit
) : Item() {

    private val columnNumber = 2


    @SuppressLint("SetTextI18n")
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        with(viewHolder.itemView) {
            Glide.with(context).load(subItem.imageUrl).into(photoImg)
            productTitle.text = subItem.title
            productPrice.text = "${context.getString(R.string.euro_symbol)} ${subItem.price}"
            productSize.text = subItem.size
            setOnClickListener { clickListener(subItem.id.toString()) }
        }
    }

    override fun getSpanSize(spanCount: Int, position: Int): Int {
        return spanCount / columnNumber
    }

    override fun getLayout() = R.layout.product_item
}