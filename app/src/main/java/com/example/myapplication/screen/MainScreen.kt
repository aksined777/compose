package com.example.myapplication.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.myapplication.R
import com.example.myapplication.ui.theme.ColorOLOLO
import com.example.myapplication.ui.theme.Cyan100
import kotlinx.coroutines.launch

@Preview(showBackground = true)
@Composable
fun MainCard() {

    Column(
        modifier = Modifier
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


@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun TabLayout() {
    val items = listOf("HOURSE", "DAYS")
    val pagerState = rememberPagerState(
        initialPage = 1,
        initialPageOffsetFraction = 0f,
        pageCount = { items.size }
    )
    val tabIndex = pagerState.currentPage
    val corutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .alpha(0.8f)
            .padding(start = 5.dp, end = 5.dp)
            .clip(RoundedCornerShape(5.dp))

    ) {
        TabRow(
            selectedTabIndex = tabIndex,
            indicator = { pos ->
                TabRowDefaults.Indicator(modifier = Modifier.tabIndicatorOffset(pos.get(tabIndex)))
            },
            containerColor = Color.Green,
            contentColor = ColorOLOLO,
        ) {
            items.forEachIndexed() { index, item ->
                Tab(
                    selected = false,
                    onClick = {
                        corutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = {
                        Text(text = item)
                    })
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1.0f)
        ) {

        }
    }
}