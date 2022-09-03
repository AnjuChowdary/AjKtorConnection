package com.ae.ajktorconnection.ktor

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserEntity(
    @SerialName("id")
    val id: String,
    @SerialName("email")
    val email: String,
    @SerialName("first_name")
    val first_name: String,
    @SerialName("last_name")
    val last_name: String,
    @SerialName("avatar")
    val avatar: String,
)

@Serializable
data class UserSupport(
    @SerialName("url")
    val url: String,
    @SerialName("text")
    val text: String
)

@Serializable
data class ReqResUserResponse(
    @SerialName("data")
    val data: UserEntity,
    @SerialName("support")
    val support: UserSupport
)
