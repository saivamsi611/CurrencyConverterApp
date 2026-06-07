package com.example.currencyconverter.Network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Apiprovider {
    private val okHttpClient = OkHttpClient()
    fun provideApi(): ApiServices = Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://api.frankfurter.dev/v2/")
        .build()
        .create(ApiServices::class.java)
}
