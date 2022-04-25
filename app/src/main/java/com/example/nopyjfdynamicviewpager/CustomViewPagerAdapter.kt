package com.example.nopyjfdynamicviewpager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.example.nopyjfdynamicviewpager.databinding.ItemCustomBannerBinding

class CustomViewPagerAdapter<T>(
    private val context: Context
) : PagerAdapter() {

    private var data = listOf<T>()

    fun setData(data: List<T>) {
        this.data = data
    }

    override fun getCount(): Int {
        return data.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemBinding = ItemCustomBannerBinding.inflate(
            LayoutInflater.from(context),
            container,
            false
        )

        if (data.isNotEmpty()) {
            val item = data[position]
            itemBinding.ivItem.setRatio(1F)
            Glide.with(context).load(item).into(itemBinding.ivItem)
        }

        container.addView(itemBinding.root)
        return itemBinding.root
    }
}