package com.example.nopyjfdynamicviewpager

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.viewpager.widget.ViewPager

class CustomViewPager(
    context: Context,
    attr: AttributeSet
) : ViewPager(context, attr) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val childWidthSpec = getChildWidthMeasureSpec(widthMeasureSpec)
        val maxChildHeightSpec = getMaxChildHeightSpec(childWidthSpec)

        if (maxChildHeightSpec != 0) {
            setMeasuredDimension(
                widthMeasureSpec,
                MeasureSpec.makeMeasureSpec(maxChildHeightSpec, MeasureSpec.EXACTLY)
            )
        }
    }

    private fun getChildWidthMeasureSpec(widthMeasureSpec: Int): Int {
        return MeasureSpec.makeMeasureSpec(
            0.coerceAtLeast(MeasureSpec.getSize(widthMeasureSpec)),
            MeasureSpec.getMode(widthMeasureSpec)
        )
    }

    private fun getMaxChildHeightSpec(childWidthMeasureSpec: Int): Int {
        var maxChildHeight = 0

        for (i in 0 until childCount) {
            val child: View = getChildAt(i)
            child.measure(childWidthMeasureSpec, MeasureSpec.UNSPECIFIED)
            val height = child.measuredHeight
            if (height > maxChildHeight) maxChildHeight = height
        }

        return maxChildHeight
    }
}