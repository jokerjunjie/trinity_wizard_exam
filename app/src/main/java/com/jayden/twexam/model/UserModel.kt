package com.jayden.twexam.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

sealed class UserModel {
    data class User(
        @SerializedName("email")
        val email: String = "",
        @SerializedName("firstName")
        val firstName: String = "",
        @SerializedName("id")
        val id: String = "",
        @SerializedName("lastName")
        val lastName: String = "",
        @SerializedName("phone")
        val phone: String = ""
    ): Serializable
}