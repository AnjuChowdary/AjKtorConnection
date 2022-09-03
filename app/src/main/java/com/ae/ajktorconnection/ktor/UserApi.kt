package com.ae.ajktorconnection.ktor

import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*

class UserApi(private val client: HttpClient) {
    suspend fun getUser(userId: String): ReqResUserResponse =
        client.get("https://reqres.in/api/users/$userId")
}