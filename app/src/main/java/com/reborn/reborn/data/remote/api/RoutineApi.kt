package com.reborn.reborn.data.remote.api

import com.reborn.reborn.data.remote.model.DataResponse
import com.reborn.reborn.data.remote.model.VoidResponse
import com.reborn.reborn.data.remote.model.response.RoutineExerciseResponse
import com.reborn.reborn.data.remote.model.response.RoutineResponse
import io.reactivex.Single
import retrofit2.http.*

interface RoutineApi {


    @GET("/routine/recommend")
    fun searchDisease() : Single<DataResponse<List<RoutineResponse>>>

    @GET("/routine/{routineToken}/exerciseList")
    fun exerciseList(
        @Path("routineToken") routineToken: String
    ) : Single<DataResponse<List<RoutineExerciseResponse>>>

    @POST("/routine/saveRoutine")
    @FormUrlEncoded
    fun saveRoutine(
        @Field("routineToken") routineToken: String,
        @Field("totalTime") totalTime: Int
    ) : Single<VoidResponse>

}