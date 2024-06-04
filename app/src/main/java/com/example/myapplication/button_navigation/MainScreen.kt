package com.example.myapplication.button_navigation

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarResult
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(context: Context) {
    val navController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        snackbarHost = { // необязательно
            SnackbarHost(hostState = it) { data ->
                Snackbar(
                    snackbarData = data,
                    backgroundColor = Color.Green,
                    shape = RoundedCornerShape(20.dp)
                )
            }
        },
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
                        coroutineScope.launch {
                            val result = scaffoldState.snackbarHostState.showSnackbar(
                                message = "OLOLO Delete",
                                actionLabel = "Undone"
                            )
                            if (result == SnackbarResult.ActionPerformed) {
                                Toast.makeText(context, "Undone", Toast.LENGTH_SHORT).show()
                            }
                        }
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