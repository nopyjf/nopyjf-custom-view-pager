package com.example.nopyjfdynamicviewpager

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

class CustomImageView(
    context: Context,
    attr: AttributeSet
) : AppCompatImageView(context, attr) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = width / 2
        setMeasuredDimension(width, height)
    }
}