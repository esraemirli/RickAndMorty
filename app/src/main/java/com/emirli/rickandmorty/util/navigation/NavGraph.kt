package com.emirli.rickandmorty.util.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.emirli.rickandmorty.ui.detail.DetailScreen
import com.emirli.rickandmorty.ui.home.HomeScreen
import com.emirli.rickandmorty.ui.splash.SplashScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination =  Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController)
        }
        composable(route = Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(route = Screen.CharacterDetail.route + "/{$CHARACTER_ID}") {
            DetailScreen(navController)
        }
    }
}