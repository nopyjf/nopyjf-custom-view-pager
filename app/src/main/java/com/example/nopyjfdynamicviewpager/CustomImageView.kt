package com.example.nopyjfdynamicviewpager

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

class CustomImageView(
    context: Context,
    private val attr: AttributeSet
) : AppCompatImageView(context, attr) {

    private var ratio = 3.2F

    init {
        initView()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = width / ratio
        setMeasuredDimension(width, height.toInt())
    }

    fun setRatio(scale: Float) {
        this.ratio = scale
    }

    private fun initView() {
        setAttributes(context, attr)
    }

    private fun setAttributes(context: Context, attrs: AttributeSet?) {
        val typeAttribute = context.obtainStyledAttributes(
            attrs, R.styleable.CustomImageView, 0, 0
        )
        ratio = typeAttribute.getFloat(R.styleable.CustomImageView_ratio, 3.2F)
        typeAttribute.recycle()
    }
}