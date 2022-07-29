package com.example.intentimpl

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.PermissionChecker

const val RC_PERMISSION_CALL = 654

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.CALL_PHONE),
            RC_PERMISSION_CALL
        )
    }

    private fun callPhone() {
        val intentImplTel = Intent(
            Intent.ACTION_CALL,
            Uri.parse("tel:0123456578")
        )
        startActivity(intentImplTel)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == RC_PERMISSION_CALL && grantResults[0] == PermissionChecker.PERMISSION_GRANTED)
            callPhone()
    }
}