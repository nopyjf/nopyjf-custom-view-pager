package com.example.nopyjfdynamicviewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.nopyjfdynamicviewpager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val urls = listOf(
        "https://picsum.photos/id/1/360/180",
        "https://picsum.photos/id/2/360/180",
        "https://picsum.photos/id/3/360/180"
    )

    private val recyclerViewAdapter = CustomRecyclerViewAdapter(urls)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvList.apply {
            layoutManager = GridLayoutManager(context, 1)
            adapter = recyclerViewAdapter
        }
    }
}