package com.jayden.twexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jayden.twexam.util.SharePreferenceUtil

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Start exam
        SharePreferenceUtil.init(this.applicationContext)
    }
}