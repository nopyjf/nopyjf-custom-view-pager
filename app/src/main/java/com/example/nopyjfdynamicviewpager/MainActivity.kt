package com.example.nopyjfdynamicviewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nopyjfdynamicviewpager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var customViewPagerAdapter = CustomViewPagerAdapter<String>(this)

    private val urls = listOf(
        "https://picsum.photos/id/1/360/180",
        "https://picsum.photos/id/2/360/180",
        "https://picsum.photos/id/3/360/180"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        customViewPagerAdapter.setData(urls)
        binding.vpCustom.adapter = customViewPagerAdapter
    }
}