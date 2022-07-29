package com.example.tpnemoubliepas

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.PermissionChecker.PERMISSION_GRANTED

class MainActivity : AppCompatActivity() {
    lateinit var editTextPhone:EditText
    lateinit var button: Button
    lateinit var numeroTel :String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editTextPhone = findViewById(R.id.editTextPhone)
        button = findViewById(R.id.button)
        button.setOnClickListener {
            numeroTel = editTextPhone.text.toString()
            //On demande la permission à l'utilisateur d'envoyer des SMS (request code = 12)
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.SEND_SMS),12)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        //Lorsque l'utilisateur
        if(requestCode==12&&grantResults[0]== PERMISSION_GRANTED)
            sendSms()
    }

    fun sendSms(){
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("sms:$numeroTel")
            putExtra("sms_body", "Ne m'oublie pas")
        }

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }else{
            Toast.makeText(this,
                "Aucun app ne peut envoyer des sms",
                Toast.LENGTH_SHORT).show()
        }
    }
}