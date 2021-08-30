package com.jayden.twexam

import android.app.Application
import com.jayden.shared.language.Strings

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Strings.context = this
    }
}