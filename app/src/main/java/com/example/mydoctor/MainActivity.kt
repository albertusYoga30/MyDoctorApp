package com.example.mydoctor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.mydoctor.view.GetStartedActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Handler(Looper.getMainLooper()).postDelayed({
//            startActivity(Intent(this, GetStartedActivity::class.java))
//        })
    }
}