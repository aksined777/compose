package com.example.myapplication.button_navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun NavGraph(
    navHostController: NavHostController
) {
    NavHost(navController = navHostController, startDestination = BottonItem.Screen1.route) {
        composable(BottonItem.Screen1.route) {
            Screen1()
        }
        composable(BottonItem.Screen2.route) {
            Screen2()
        }
        composable(BottonItem.Screen3.route) {
            Screen3()
        }
        composable(BottonItem.Screen4.route) {
            Screen4()
        }
    }
}



