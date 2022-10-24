package com.reborn.reborn.data.remote.model.response

import com.reborn.reborn.data.common.model.User

data class UserResponse(
    val user: User,
    val accessToken: String,
    val refreshToken: String
)