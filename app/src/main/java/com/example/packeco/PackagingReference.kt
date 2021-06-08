package com.example.packeco

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore

class PackagingReference : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_packaging_reference)
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        img_view.setImageURI(data?.data)
//
//        var uri : Uri?= data?.data
//        bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, uri)
//    }
}