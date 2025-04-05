package com.poc.grpc

import UserResponseKt
import org.springframework.grpc.server.service.GrpcService

@GrpcService
class UserService : UserServiceGrpcKt.UserServiceCoroutineImplBase() {

    override suspend fun getUser(request: User.GetUserRequest): User.UserResponse {
        return User.UserResponse.newBuilder().setUserId("1").setName("Rafa").setEmail("encinas008@gmail.com").build()
    }
}
