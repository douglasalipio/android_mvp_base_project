package com.baseproject.interview.util

import androidx.annotation.ColorInt
import androidx.annotation.Dimension

class ProductDecorator(@ColorInt backgroundColor: Int, @Dimension padding: Int) :
    InsetItemDecoration(backgroundColor, padding, "inset_type", "insert")