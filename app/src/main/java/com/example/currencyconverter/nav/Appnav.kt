package com.example.currencyconverter.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.currencyconverter.screens.ExchangeScreen
import com.example.currencyconverter.screens.HomeScreen
import com.example.currencyconverter.viewmodel.myviewmodel

@Composable
fun AppNav(viewmodel: myviewmodel) {

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.HomeRoute
    ) {
        composable<Routes.HomeRoute> {
            HomeScreen(navController = navController, viewmodel = viewmodel)
        }
        composable<Routes.ExchangeRoute> {
            val route = it.toRoute<Routes.ExchangeRoute>()
            ExchangeScreen(navController = navController, viewmodel = viewmodel, base = route.base)
        }
    }

}