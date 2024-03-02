package com.example.jetcrud_mvvm.feature_user.presentation.home

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetcrud_mvvm.feature_user.presentation.edit.components.EditScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun navigation() {

    val navController = rememberNavController()

    NavHost(

        navController = navController,
        startDestination = Screen.Home.route

    ){
        composable(route = Screen.Home.route ) {
            HomeScreen(navController  = navController)
        }
        composable(
            route = Screen.edit.route,
            arguments = listOf(
                navArgument(
                    name = "userId"
                ) {
                    type = NavType.IntType
                    defaultValue = -1
                }
            )
        ) {
            EditScreen(navController = navController)
        }

    }

}
