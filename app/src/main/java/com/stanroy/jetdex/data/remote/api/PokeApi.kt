package com.stanroy.jetdex.data.remote.api

import com.stanroy.jetdex.data.remote.response.list.MonListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PokeApi {

    @GET("pokemon")
    suspend fun getMonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): MonListResponse

}