package com.alnazo.httpcatserrors.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.alnazo.httpcatserrors.view.AboutScreen
import com.alnazo.httpcatserrors.view.CatErrorScreen
import com.alnazo.httpcatserrors.view.MainScreen
import com.alnazo.httpcatserrors.view.SplashScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = AppScreen.SplashScreen.route){
        composable(AppScreen.SplashScreen.route){
            SplashScreen(navController)
        }
        composable(AppScreen.MainScreen.route){
            MainScreen(navController)
        }
        composable(AppScreen.AboutScreen.route){
            AboutScreen(navController)
        }
        composable(
            route = AppScreen.CatErrorScreen.route+"/{catErrorId}",
            arguments = listOf(
                navArgument("catErrorId") { type = NavType.IntType }
            )){ backStackEntry ->
            val id = backStackEntry.arguments?.getInt("catErrorId")
            requireNotNull(id)
            CatErrorScreen(navController, id)
        }
    }
}