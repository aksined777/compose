package com.example.myapplication

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LazyRow(modifier = Modifier.fillMaxSize()
                .background(Color.Gray)
            ) {

                itemsIndexed(
                    listOf(
                        DataItem(R.drawable.islands, "OLOLO"),
                        DataItem(R.drawable.islands, "qaz"),
                        DataItem(R.drawable.islands, "OPOPO"),
                        DataItem(R.drawable.islands, "Image"),
                        DataItem(R.drawable.islands, "Zlo"),
                        DataItem(R.drawable.islands, "1111"),
                        DataItem(R.drawable.islands, "2222"),
                        DataItem(R.drawable.islands, "3333"),
                        DataItem(R.drawable.islands, "4444"),
                        DataItem(R.drawable.islands, "5555"),
                    )
                ) { index, item ->
                    ViewItem(item = item)
                }
            }
        }
    }
}

