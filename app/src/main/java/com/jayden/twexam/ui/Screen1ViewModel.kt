package com.jayden.twexam.ui

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jayden.shared.DatabaseDriverFactory
import com.jayden.shared.db.Database
import com.jayden.shared.model.UserModel.User
import com.jayden.shared.repo.MembersRepo
import com.jayden.twexam.util.JsonParserUtil
import com.jayden.twexam.util.SharePreferenceUtil
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch


class Screen1ViewModel() : ViewModel() {

    private val membersRepository by lazy { MembersRepo() }

    private val _userResData = MutableLiveData<List<User>>()
    val userListResData: LiveData<List<User>> = _userResData
    var userListData: ArrayList<User> = arrayListOf()

    fun getUserList(context: Context) {
        val jsonVal: String = if(SharePreferenceUtil.userList.isNotEmpty()){
            SharePreferenceUtil.userList
        }else{
            JsonParserUtil.getJsonDataFromAsset(context, "data.json").toString()
        }
        Log.i("data", jsonVal)
        val listType = object : TypeToken<List<User>>() {}.type
        val users: List<User> = Gson().fromJson(jsonVal.trim(), listType)
        SharePreferenceUtil.userList = jsonVal
        userListData.clear()
        userListData.addAll(users)
        _userResData.postValue(users)
    }

    fun getGithubMembers(){
        viewModelScope.launch {
            membersRepository.getMembersFlowFromRemote()
                .onStart {
                    Log.d("Screen1Fragment", "onStart")
                }.onCompletion {
                    Log.d("Screen1Fragment", "onCompletion")
                }.catch {
                    Log.d("Screen1Fragment", it.toString())
                }.collect {
                    Log.d("Screen1Fragment", it.toString())
                }
        }
    }

    fun insertValueIntoDb(context: Context){
        val sharedDb = Database(DatabaseDriverFactory(context = context))
        sharedDb.insert("testing")
    }

    fun readFromDb(context: Context){
        val sharedDb = Database(DatabaseDriverFactory(context = context))
        Log.i("Database value", sharedDb.getData().toString())
    }

}