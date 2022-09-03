package com.ae.ajktorconnection.ktor

import arrow.core.Either
import io.ktor.client.features.*
import io.ktor.server.cio.backend.*
import java.nio.channels.ServerSocketChannel

class UserRepository(val userApi: UserApi) {
    //TODO: Use Fialure instead of Exception
    suspend fun getUserKtor(userId: String): Either<Exception, ReqResUserResponse> {
        return try {
            Either.Right(userApi.getUser(userId))
        } catch (e: Exception) {
            Either.Left(e)
        }
    }
}
