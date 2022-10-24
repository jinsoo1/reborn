package com.reborn.reborn.data.remote.model.response

data class UserInformationResponse(
    val name : String,
    val gender : String?,
    val birth : String?,
    val height : String,
    val weight : String
)