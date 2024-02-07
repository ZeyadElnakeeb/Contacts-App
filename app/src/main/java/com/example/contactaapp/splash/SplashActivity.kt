package com.example.contactaapp.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.contactaapp.MainActivity
import com.example.contactaapp.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

Handler(Looper.getMainLooper()).postDelayed({
    var intent=Intent(applicationContext,MainActivity::class.java)
    startActivity(intent)
    finish()
},2000)


    }

}