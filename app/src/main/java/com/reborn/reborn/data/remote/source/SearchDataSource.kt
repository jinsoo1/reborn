package com.reborn.reborn.data.remote.source

import com.reborn.reborn.data.remote.api.SearchApi
import com.reborn.reborn.data.remote.model.response.MainSearchResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SearchDataSource(
    private val searchApi: SearchApi
) {



    fun searchDisease(
        query : String
    ) : Single<List<MainSearchResponse>>{
        return searchApi.searchDisease(query)
            .subscribeOn(Schedulers.io())
            .map { it.data }
            .observeOn(AndroidSchedulers.mainThread())
    }
}