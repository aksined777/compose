package com.example.myapplication.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.myapplication.R
import com.example.myapplication.ui.theme.ColorOLOLO
import com.example.myapplication.ui.theme.Cyan100
import java.nio.file.WatchEvent

@Preview(showBackground = true)
@Composable
fun MainScreen() {
    Image(
        painter = painterResource(id = R.drawable.mks),
        contentDescription = "im1",
        modifier = Modifier
            .fillMaxSize()
            .alpha(0.9f),
        contentScale = ContentScale.FillBounds
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .alpha(0.5f),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            ),
            shape = RoundedCornerShape(10.dp),

            colors = CardDefaults.cardColors(containerColor = Cyan100)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {


                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            modifier = Modifier.padding(PaddingValues(10.dp, 10.dp, 0.dp, 0.dp)),
                            text = "20 Jun",
                            style = TextStyle(fontSize = 15.sp),
                            color = Color.White
                        )

                        AsyncImage(
                            model = "https://cdn.weatherapi.com/weather/64x64/day/116.png",
                            contentDescription = "im2",
                            modifier = Modifier.size(35.dp)
                        ) // coil library
                    }
                    Text(
                        modifier = Modifier.padding(PaddingValues(10.dp, 10.dp, 0.dp, 0.dp)),
                        text = "Oslo",
                        style = TextStyle(fontSize = 24.sp),
                        color = Color.White
                    )
                    Text(
                        modifier = Modifier.padding(PaddingValues(10.dp, 10.dp, 0.dp, 0.dp)),
                        text = "25 C",
                        style = TextStyle(fontSize = 45.sp),
                        color = Color.White
                    )
                    Text(
                        modifier = Modifier.padding(PaddingValues(10.dp, 10.dp, 0.dp, 0.dp)),
                        text = "Sunny",
                        style = TextStyle(fontSize = 16.sp),
                        color = Color.White
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.search_24),
                                contentDescription = "Img3",
                                tint = Color.White
                            )
                        }
                        Text(
                            modifier = Modifier.padding(PaddingValues(10.dp, 10.dp, 0.dp, 0.dp)),
                            text = "23 C/12 C",
                            style = TextStyle(fontSize = 16.sp),
                            color = Color.White
                        )

                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.cloud_sync_24),
                                contentDescription = "Img4",
                                tint = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}