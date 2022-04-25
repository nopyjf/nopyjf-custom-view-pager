package com.example.nopyjfdynamicviewpager

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nopyjfdynamicviewpager.databinding.ItemCustomBannerBinding

class CustomViewPagerTwoAdapter : RecyclerView.Adapter<CustomViewPagerTwoAdapter.ViewHolder>() {

    private var data: List<String> = arrayListOf()

    fun setData(data: List<String>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = ItemCustomBannerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(parent.context, binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class ViewHolder(
        private val context: Context,
        private val itemBinding: ItemCustomBannerBinding,
    ) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(data: String) {
            itemBinding.ivItem.setRatio(3.2F)
            Glide.with(context).load(data).into(itemBinding.ivItem)
        }
    }
}