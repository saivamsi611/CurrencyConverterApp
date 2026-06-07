package com.example.currencyconverter.Network

import com.example.currencyconverter.data.DataResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices{

    @GET("rates")
    suspend fun getRates(): Response<DataResponse>

@GET("rates")
suspend fun getRates(@Query("base") base: String): Response<DataResponse>
}
