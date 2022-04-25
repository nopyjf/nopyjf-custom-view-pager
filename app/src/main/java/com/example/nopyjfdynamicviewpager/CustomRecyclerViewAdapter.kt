package com.example.nopyjfdynamicviewpager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.nopyjfdynamicviewpager.databinding.ItemCustomBannerWithDotBinding

class CustomRecyclerViewAdapter(
    private var data: List<String> = arrayListOf()
) : RecyclerView.Adapter<CustomRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCustomBannerWithDotBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding, data)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = 3

    inner class ViewHolder(
        private val itemBinding: ItemCustomBannerWithDotBinding,
        data: List<String>
    ) : RecyclerView.ViewHolder(itemBinding.root) {

        private val customViewPagerAdapter = CustomViewPagerTwoAdapter()
        private val fakeData = data.createFakeList()

        fun bind() {
            itemBinding.vpCustom.apply {
                adapter = customViewPagerAdapter
                displayPreview(context)
                customViewPagerAdapter.setData(fakeData)
                setEndless(fakeData) { position ->
                    itemBinding.tvDot.text = "${position - TWO}"
                }
            }
        }
    }

    companion object {
        private const val ZERO = 0
        private const val ONE = 1
        private const val TWO = 2
        private const val THREE = 3
    }
}