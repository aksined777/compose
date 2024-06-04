package com.example.myapplication.button_navigation

import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.myapplication.ui.theme.ColorOLOLO
import com.example.myapplication.ui.theme.Cyan100

@Composable
fun BottonNavigation(
    navController: NavController
) {
    val listItem =
        listOf(BottonItem.Screen1, BottonItem.Screen2, BottonItem.Screen3, BottonItem.Screen4)

    androidx.compose.material.BottomNavigation(
        backgroundColor = Cyan100
    ) {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route
        listItem.forEach { item ->
            BottomNavigationItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route)
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.iconId),
                        contentDescription = "icon"
                    )
                },
                label = {
                    Text(text = item.title, fontSize = 9.sp)
                },
                selectedContentColor = ColorOLOLO,
                unselectedContentColor = androidx.compose.ui.graphics.Color.Gray
            )
        }
    }
}