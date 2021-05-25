package com.jayden.twexam.ui

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jayden.twexam.model.UserModel
import com.jayden.twexam.model.UserModel.User
import com.jayden.twexam.util.JsonParserUtil
import java.lang.reflect.Type


class Screen1ViewModel : ViewModel() {

    private val _userResData = MutableLiveData<List<User>>()
    val userListResData: LiveData<List<User>> = _userResData
    var userListData: ArrayList<User> = arrayListOf()

    fun getUserList(context: Context) {
        val jsonVal :String = JsonParserUtil.getJsonDataFromAsset(context, "data.json").toString()
        Log.i("data", jsonVal)

//        var listType = object:TypeToken<List<User>>() {}.type
//        val users: List<User> = Gson().fromJson(jsonVal.trim(),listType)
        userListData.add(User(email = "testing" , firstName = "firstName",id = "1", lastName = "lastName" , phone = "123123"))
        _userResData.postValue(userListData)
    }

}