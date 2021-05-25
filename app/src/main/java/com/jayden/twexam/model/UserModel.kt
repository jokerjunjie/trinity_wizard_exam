package com.jayden.twexam.model

sealed class UserModel {
    data class User(
        val email: String,
        val firstName: String,
        val id: String,
        val lastName: String,
        val phone: String
    )

    data class Userlist(
        val userList: ArrayList<User> = arrayListOf()
    )


}