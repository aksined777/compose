package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
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
                        .offset(x = 50.dp, y = 90.dp)
                ) {
                    ListItem("Name", "Prof", context)
                    ListItem("Name", "Prof", context)
                    ListItem("Name", "Prof", context)
                    ListItem("Name", "Prof", context)
                    ListItem("Name", "Prof", context)
                    ListItem("Name", "Prof", context)
                    ListItem("Name", "Prof", context)
                    ListItem("Name", "Prof", context)
                    ListItem("Name", "Prof", context)
                    ListItem("Name", "Prof", context)
                    ListItem("Name", "Prof", context)
                    ListItem("Name", "Prof", context)
                    ListItem("Name", "Prof", context)
                    ListItem("Name", "Prof", context)
                    ListItem("Name", "Prof", context)
                    ListItem("Name", "Prof", context)
                    ListItem("Name", "Prof", context)

                }

            }
        }
    }
}


@Composable
private fun ListItem(name: String, prof: String, context: Context) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .pointerInput(Unit) {
                detectDragGesturesAfterLongPress { change, dragAmount ->
                    Log.d("OLOLO", "Long press ${change.pressed}")
                    Log.d("OLOLO", "Long press $dragAmount")
                }
            }
            .clickable {
                Toast
                    .makeText(context, "&name $prof", Toast.LENGTH_SHORT)
                    .show()
            },
        shape = RoundedCornerShape(5.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Box(
            modifier = Modifier
                .background(Color.Green)
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
                    Text(text = stringResource(id = R.string.app_name))
                    Text(text = name)
                    Text(text = prof)
                }
            }

        }
    }

}