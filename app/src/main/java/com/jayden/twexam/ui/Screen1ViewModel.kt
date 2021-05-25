package com.jayden.twexam.ui

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.jayden.twexam.model.UserModel
import com.jayden.twexam.util.JsonParserUtil

class Screen1ViewModel : ViewModel(){

    private val _userResData = MutableLiveData<UserModel.User>()
    val userResData : LiveData<UserModel.User> = _userResData

    fun getUserList(context: Context){
        val gson = Gson()
        val jsonVal = JsonParserUtil.getJsonDataFromAsset(context, "data.json")
        Log.i("data",jsonVal.toString())
//        val userList: UserModel.User =
    }

}