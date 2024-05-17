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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val context = LocalContext.current
            MyApplicationTheme {
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                ) {
                    repeat(10) {
                        ListItem("Name", "Prof", context)
                    }
                }
            }
        }
    }
}


@Composable
private fun ListItem(name: String, prof: String, context: Context) {
    val counter = remember {
        mutableStateOf(0)
    }
    val color = remember {
        mutableStateOf(Color.White)
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {

                when (++counter.value) {
                    1 -> color.value = Color.Magenta
                    2 -> color.value = Color.Red
                    4 -> color.value = Color.Cyan
                    5 -> color.value = Color.Green
                    7 -> color.value = Color.Black
                    9 -> color.value = Color.Yellow
                    11 -> color.value = Color.White
                    12 -> color.value = Color.Magenta
                    14 -> color.value = Color.Gray
                    15 -> color.value = Color.Transparent
                    17 -> color.value = Color.Blue
                    18 -> counter.value = 0
                }
            },
        shape = RoundedCornerShape(5.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Box(
            modifier = Modifier
                .background(color.value)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.background(Color.Yellow)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.islands),
                    contentDescription = "Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding()
                        .size(64.dp)
                        .clip(CircleShape)
                )

                Column(modifier = Modifier.padding(20.dp)) {
                    Text(text = counter.value.toString())
                    Text(text = name)
                    Text(text = prof)
                }
            }

        }
    }

}