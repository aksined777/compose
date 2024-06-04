package com.example.myapplication.button_navigation

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(context: Context) {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Title")
                },
                backgroundColor = Color.Red,
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Filled.Menu, contentDescription = "Nenu")
                    }
                },
                actions = {
                    IconButton(onClick = {
                        Toast.makeText(context, "Face", Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(imageVector = Icons.Filled.Face, contentDescription = "Nenu")
                    }
                    IconButton(onClick = {
                        Toast.makeText(context, "Delete", Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(imageVector = Icons.Filled.Delete, contentDescription = "Nenu")
                    }
                }
            )
        },
        bottomBar = {
            BottonNavigation(navController = navController)

        }
    ) {
        NavGraph(navHostController = navController)
    }
}