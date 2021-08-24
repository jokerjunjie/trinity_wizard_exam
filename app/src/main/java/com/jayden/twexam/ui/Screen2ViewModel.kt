package com.jayden.twexam.ui

import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jayden.shared.model.UserModel
import com.jayden.twexam.util.SharePreferenceUtil

class Screen2ViewModel : ViewModel() {

    fun updateUserList(updateUserItem: UserModel.User) {
        var listType = object : TypeToken<List<UserModel.User>>() {}.type
        var users: List<UserModel.User> = Gson().fromJson(SharePreferenceUtil.userList, listType)
        users.find { updateUserItem.id == it.id }.let {
            it?.email = updateUserItem.email
            it?.firstName = updateUserItem.firstName
            it?.lastName = updateUserItem.lastName
            it?.phone = updateUserItem.phone
        }
        SharePreferenceUtil.userList = Gson().toJson(users)
    }
}