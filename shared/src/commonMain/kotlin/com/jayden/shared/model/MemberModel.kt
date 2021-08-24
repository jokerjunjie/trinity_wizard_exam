package com.jayden.shared.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MemberModel(
  val id: Long,
  val login: String,
  @SerialName("avatar_url") val avatarUrl: String
)
