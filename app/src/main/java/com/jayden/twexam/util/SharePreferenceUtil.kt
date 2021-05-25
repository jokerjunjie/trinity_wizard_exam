package com.jayden.twexam.util

import android.content.Context
import android.content.SharedPreferences

object SharePreferenceUtil {
    private lateinit var preferences: SharedPreferences

    fun init(context: Context) {
        preferences = context.getSharedPreferences("file", Context.MODE_PRIVATE)
    }

    var userList: String
        get() {
            return preferences.getString("USER_LIST", "").toString()
        }
        set(value) {
            preferences.edit().putString("USER_LIST", value).apply()
        }
}