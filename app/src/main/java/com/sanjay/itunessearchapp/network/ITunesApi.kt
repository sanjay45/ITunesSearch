package com.sanjay.itunessearchapp.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ITunesApi {

    @GET("search")
    suspend fun searchSongs(
        @Query("term") artist:String
    ): Response<ITunesApiResponse>
}