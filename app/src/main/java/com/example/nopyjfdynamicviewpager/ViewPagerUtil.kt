package com.example.nopyjfdynamicviewpager

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

fun ViewPager2.displayPreview(context: Context) {
    val nextItemSize = context.resources.getDimensionPixelSize(R.dimen.dp_15)
    val currentItemMarginSize = context.resources.getDimensionPixelSize(R.dimen.dp_20)
    val pageTranslationX = nextItemSize + currentItemMarginSize
    val pageTransformer = ViewPager2.PageTransformer { page: View, position: Float ->
        page.translationX = -pageTranslationX * position
    }
    val itemDecoration = object : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            outRect.left = currentItemMarginSize
            outRect.right = currentItemMarginSize
        }
    }

    this.offscreenPageLimit = 2
    this.setPageTransformer(pageTransformer)
    this.addItemDecoration(itemDecoration)
}

fun ViewPager2.setEndless(
    data: List<Any>,
    changeDot: (Int) -> Unit,
) {
    this.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            if (position >= 2 && position < data.size - 2) {
                changeDot(position)
            }
        }

        override fun onPageScrollStateChanged(state: Int) {
            super.onPageScrollStateChanged(state)
            if (isScrollIdleDragging(state)) {
                if (currentItem == 1) {
                    setCurrentItem(data.size - 3, false)
                } else if (currentItem == data.size - 2) {
                    setCurrentItem(2, false)
                }
            }
        }
    })

    this.setCurrentItem(2, false)
}

fun isScrollIdleDragging(state: Int): Boolean {
    return state == ViewPager2.SCROLL_STATE_IDLE || state == ViewPager2.SCROLL_STATE_DRAGGING
}