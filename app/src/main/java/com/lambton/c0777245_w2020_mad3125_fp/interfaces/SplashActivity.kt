package com.lambton.c0777245_w2020_mad3125_fp.interfaces

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.lambton.c0777245_w2020_mad3125_fp.R
import com.lambton.c0777245_w2020_mad3125_fp.interfaces.SplashActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar!!.hide()
        Handler().postDelayed({
            val i = Intent(this@SplashActivity,
                    LoginActivity::class.java)
            //Intent is used to switch from one activity to another.
            startActivity(i)
            //invoke the SecondActivity.
            finish()
            //the current activity will get finished.
        }, SPLASH_SCREEN_TIME_OUT.toLong())
    }

    companion object {
        private const val SPLASH_SCREEN_TIME_OUT = 5000
    }
}