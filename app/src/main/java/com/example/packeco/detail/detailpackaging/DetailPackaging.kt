package com.example.packeco.detail.detailpackaging

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.packeco.R
import com.example.packeco.databinding.ActivityDetailPackagingBinding
import com.example.packeco.detail.detailvendor.DetailVendor

class DetailPackaging : AppCompatActivity() {
    private lateinit var binding: ActivityDetailPackagingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPackagingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tab.addTab(binding.tab.newTab().setText(R.string.price))
        binding.tab.addTab(binding.tab.newTab().setText(R.string.rating))

        binding.dummyvendor.setOnClickListener{
            val intent = Intent(this@DetailPackaging, DetailVendor::class.java)
            startActivity(intent)
        }
    }
}