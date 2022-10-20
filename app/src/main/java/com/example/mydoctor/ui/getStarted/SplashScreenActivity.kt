package com.example.mydoctor.ui.getStarted

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.mydoctor.R
import com.example.mydoctor.data.preference.Const
import com.example.mydoctor.ui.homeNavigation.HomeNavigationActivity
import com.example.mydoctor.ui.main.MainActivity

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        supportActionBar!!.hide()

        val sharedPreferences: SharedPreferences =
            applicationContext.getSharedPreferences(Const.PREF_NAME, Context.MODE_PRIVATE)

        val firstStart: Boolean = sharedPreferences.getBoolean(Const.IS_FIRST_START, true)

        Handler(Looper.getMainLooper()).postDelayed({
            if (isLogin(sharedPreferences)) {
                startActivity(Intent(this, HomeNavigationActivity::class.java))
                finish()
            } else if (firstStart) {
                showOnBoardingPage(sharedPreferences)
            } else {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }, 1000)

    }

    private fun isLogin(sharedPreferences: SharedPreferences): Boolean {
        return sharedPreferences.getBoolean(Const.IS_LOGIN, false)
    }

    private fun showOnBoardingPage(sharedPreferences: SharedPreferences) {
        startActivity(Intent(this,MainActivity::class.java))
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putBoolean(Const.IS_FIRST_START, false)
        editor.apply()
    }

}