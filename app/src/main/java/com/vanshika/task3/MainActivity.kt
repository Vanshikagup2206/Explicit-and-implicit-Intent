package com.vanshika.task3

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var btnDial : Button?=null
    var btnOpenWebsite : Button?=null
    var btnSms : Button?=null
    var btnEmail : Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnDial = findViewById(R.id.btnDial)
        btnOpenWebsite = findViewById(R.id.btnOpenWebsite)
        btnSms = findViewById(R.id.btnSms)
        btnEmail = findViewById(R.id.btnEmail)
        btnDial?.setOnClickListener {
            try {
                var intent = Intent(Intent.ACTION_DIAL)
                intent.setData(Uri.parse("tel:xxxxxxxxxx"))
                startActivity(intent)
            } catch (exception: Exception) {
                Toast.makeText(this, "Sorry cannot dial a number", Toast.LENGTH_LONG).show()
            }
            btnOpenWebsite?.setOnClickListener {
                var intent = Intent(Intent.ACTION_VIEW)
                intent.setData(Uri.parse("https://o7services.com/"))
                startActivity(intent)
            }
            btnSms?.setOnClickListener {
                try {
                    var intent = Intent(Intent.ACTION_VIEW)
                    intent.setData(Uri.parse("sms:xxxxxxxxxx"))
                    startActivity(intent)
                } catch (exception: Exception) {
                    Toast.makeText(this, "Sorry cannot send the sms", Toast.LENGTH_LONG).show()
                }
            }
            btnEmail?.setOnClickListener {
                try {
                    var intent = Intent(Intent.ACTION_SEND)
                    intent.setType("text/email")
                    startActivity(intent)
                } catch (exception: Exception) {
                    Toast.makeText(this, "Sorry cannot send the email", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}