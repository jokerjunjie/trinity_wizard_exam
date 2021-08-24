package com.jayden.shared.model


import kotlinx.serialization.SerialName
import java.io.Serializable

sealed class UserModel {
    data class User(
        @SerialName("id")
        val id: String = "",
        @SerialName("firstName")
        var firstName: String = "",
        @SerialName("lastName")
        var lastName: String = "",

        @SerialName("email")
        var email: String = "",
        @SerialName("phone")
        var phone: String = ""
    ): Serializable
}