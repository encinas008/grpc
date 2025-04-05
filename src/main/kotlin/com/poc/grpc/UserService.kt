package com.poc.grpc

import User
import UserServiceGrpcKt
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.springframework.grpc.server.service.GrpcService

@GrpcService
class UserService : UserServiceGrpcKt.UserServiceCoroutineImplBase() {

    override suspend fun getUser(request: User.GetUserRequest): User.UserResponse {
        return User.UserResponse.newBuilder().setUserId("1").setName("Rafa").setEmail("encinas008@gmail.com").build()
    }

    override fun listUsers(request: User.ListUsersRequest): Flow<User.UserResponse> = flow {

        repeat(8) { i ->
            val id = i + 1
            val user = User.UserResponse.newBuilder()
                .setUserId(id.toString())
                .setName("User $id")
                .setEmail("encinas00$id@gmail.com")
                .build()

            emit(user)

            delay(500)
        }
    }
}
