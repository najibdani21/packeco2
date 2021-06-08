package com.example.packeco.home

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Camera
import android.hardware.Camera.open
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.ParcelFileDescriptor.open
import android.provider.MediaStore
import android.system.Os.open
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.example.packeco.R
import com.example.packeco.databinding.ActivityMainBinding
import com.example.packeco.detail.detailpackaging.DetailPackaging

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val rotateOpen: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.rotate_open_anim) }
    private val rotateClose: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.rotate_close_anim) }
    private val fromBottom: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.from_bottom_anim) }
    private val toBottom: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.to_bottom_anim) }

    lateinit var bitmap: Bitmap

    private var clicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fabPhoto.setOnClickListener{
            onAddButtonClicked()
        }

        binding.fabGalery.setOnClickListener{
            Log.d("mssg", "button pressed")
            var intent : Intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"

            startActivityForResult(intent, 100)
        }

        binding.fabCamera.setOnClickListener{
            Toast.makeText(applicationContext, "Take Photo", Toast.LENGTH_SHORT).show()
        }

        binding.cvItem.setOnClickListener{
            val intent = Intent(this@MainActivity, DetailPackaging::class.java)
            startActivity(intent)
        }
    }

    private fun onAddButtonClicked() {
        setVisibility(clicked)
        setAnimation(clicked)
        clicked = !clicked
    }

    private fun setAnimation(clicked: Boolean) {
        if (!clicked){
            binding.fabGalery.startAnimation(fromBottom)
            binding.fabCamera.startAnimation(fromBottom)
            binding.fabPhoto.startAnimation(rotateOpen)
        }else{
            binding.fabGalery.startAnimation(toBottom)
            binding.fabCamera.startAnimation(toBottom)
            binding.fabPhoto.startAnimation(rotateClose)
        }
    }

    private fun setVisibility(clicked: Boolean) {
        if (!clicked){
            binding.fabGalery.visibility = View.VISIBLE
            binding.fabCamera.visibility = View.VISIBLE
        }else{
            binding.fabGalery.visibility = View.INVISIBLE
            binding.fabCamera.visibility = View.INVISIBLE
        }
    }

    /** Check if this device has a camera */
    private fun checkCameraHardware(context: Context): Boolean {
        if (context.packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            // this device has a camera
            return true
        } else {
            // no camera on this device
            return false
        }
    }


}