package com.reborn.reborn.data.remote.api

import com.reborn.reborn.data.remote.model.DataResponse
import com.reborn.reborn.data.remote.model.response.DetailExerciseResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ExerciseApi {


    @GET("/exercise/{exerciseToken}/detail")
    fun detailExercise(
        @Path("exerciseToken") exerciseToken: String
    ) : Single<DataResponse<DetailExerciseResponse>>

}