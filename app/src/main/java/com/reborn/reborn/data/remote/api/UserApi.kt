package com.reborn.reborn.data.remote.api

import com.reborn.reborn.data.remote.model.DataResponse
import com.reborn.reborn.data.remote.model.VoidResponse
import com.reborn.reborn.data.remote.model.response.UserInformationResponse
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface UserApi {

    @POST("/user/account")
    @FormUrlEncoded
    fun setAccount(
        @Field("height") height : Int,
        @Field("weight") weight : Int,
        @Field("level") level : String,
        @Field("terms") terms : Int
    ) : Single<VoidResponse>


    @GET("/user/information")
    fun getUserInformation() : Single<DataResponse<UserInformationResponse>>

}