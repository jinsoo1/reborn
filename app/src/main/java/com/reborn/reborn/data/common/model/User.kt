package com.reborn.reborn.data.common.model

data class User(
    val userType: String,
    val userToken: String,
    val name: String,
    val email: String,
    val profileImg: String?,
    val agree : Int
)
