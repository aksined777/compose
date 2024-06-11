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
            Screen4({
                navHostController.navigate("Screen_5")
            })
        }
        composable("Screen_5" ){
            Screen5({
                navHostController.navigate("Screen_6")
            })
        }
        composable("Screen_6" ){
            Screen6({
                navHostController.navigate(BottonItem.Screen4.route) {
                    popUpTo(BottonItem.Screen4.route)
                }
            })
        }
    }
}



