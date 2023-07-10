package com.fitpeo.assignment

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fitpeo.assignment.screen.loaddata.LoadDataActivity

class SplashActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, LoadDataActivity::class.java))
        finish()
    }
}