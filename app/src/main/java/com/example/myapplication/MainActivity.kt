package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.myapplication.screen.MainCard
import com.example.myapplication.screen.TabLayout

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Image(
                painter = painterResource(id = R.drawable.mks),
                contentDescription = "im1",
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(0.9f),
                contentScale = ContentScale.FillBounds
            )
            Column {
                MainCard()
                TabLayout()
            }
        }
    }

}
