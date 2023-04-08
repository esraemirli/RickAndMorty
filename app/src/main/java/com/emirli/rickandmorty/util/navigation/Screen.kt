package com.emirli.rickandmorty.util.navigation

sealed class Screen(val route : String){
    object Splash : Screen("splash_screen")
    object Home : Screen("home_screen")
    object CharacterDetail : Screen("character_detail_screen")
}