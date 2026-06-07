package com.example.currencyconverter.nav

import kotlinx.serialization.Serializable

sealed class Routes{
    @Serializable
    object HomeRoute
@Serializable
     data class ExchangeRoute(val base: String)
}
