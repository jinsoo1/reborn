package com.reborn.reborn.data.remote.api

import com.reborn.reborn.data.remote.model.VoidResponse
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface PainApi {


    @POST("/pain/setPain")
    @FormUrlEncoded
    fun setPain(
        @Field("purpose") purpose : String,
        @Field("diseaseCode") diseaseCode : String,
        @Field("painSpot") painSpot : String,
        @Field("static") static : Int,
        @Field("dynamic") dynamic : Int
    ) : Single<VoidResponse>

}