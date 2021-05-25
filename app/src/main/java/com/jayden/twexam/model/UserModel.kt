package com.jayden.twexam.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

sealed class UserModel {
    data class User(
        @SerializedName("id")
        val id: String = "",
        @SerializedName("firstName")
        var firstName: String = "",
        @SerializedName("lastName")
        var lastName: String = "",

        @SerializedName("email")
        var email: String = "",
        @SerializedName("phone")
        var phone: String = ""
    ): Serializable
}