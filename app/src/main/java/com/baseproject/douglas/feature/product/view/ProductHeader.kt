package com.baseproject.douglas.feature.product.view

import com.baseproject.douglas.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.product_header.view.*

class ProductHeader(private val title: String) : Item() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.headerTitle.text = title
    }

    override fun getLayout() = R.layout.product_header
}
