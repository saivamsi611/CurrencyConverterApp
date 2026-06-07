package com.example.currencyconverter.data

data class DataResponseItem(
    val base: String,
    val date: String,
    val quote: String,
    val rate: Double
)