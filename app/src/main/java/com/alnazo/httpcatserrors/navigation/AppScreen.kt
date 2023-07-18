package com.alnazo.httpcatserrors.navigation

sealed class AppScreen (val route: String){
    object SplashScreen: AppScreen("splash_screen")
    object MainScreen: AppScreen("main_screen")
    object AboutScreen: AppScreen("about_screen")
    object CatErrorScreen: AppScreen("caterror_screen")
}