package com.reborn.reborn.data.remote.api

import com.reborn.reborn.data.remote.model.DataResponse
import com.reborn.reborn.data.remote.model.response.MainSearchResponse
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface SearchApi {


    @POST("/disease/search/main")
    @FormUrlEncoded
    fun searchDisease(
        @Field("query") query : String
    ) : Single<DataResponse<List<MainSearchResponse>>>


}