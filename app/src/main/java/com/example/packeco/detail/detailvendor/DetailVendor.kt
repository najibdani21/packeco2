package com.example.packeco.detail.detailvendor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.packeco.databinding.ActivityDetailPackagingBinding
import com.example.packeco.databinding.ActivityDetailVendorBinding

class DetailVendor : AppCompatActivity() {
    private lateinit var binding: ActivityDetailVendorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailVendorBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}