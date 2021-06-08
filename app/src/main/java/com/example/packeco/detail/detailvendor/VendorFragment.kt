package com.example.packeco.detail.detailvendor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.packeco.databinding.FragmentVendorBinding

class VendorFragment : Fragment() {
    private lateinit var binding: FragmentVendorBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVendorBinding.inflate(inflater, container, false)
        return binding?.root
    }

}