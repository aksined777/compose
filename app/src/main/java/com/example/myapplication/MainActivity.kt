package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                NewText()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewText() {
    Row(Modifier.fillMaxSize().background(Color.Gray), horizontalArrangement = Arrangement.SpaceEvenly
        ) {
        Column(Modifier.background(Color.Red)
            .fillMaxHeight(0.5f)
            .fillMaxWidth(0.5f), // 50% screen
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.End){
            Text(text = "OLOLO")
            Text(text = "QAZ", )
            Text(text = "QAZ", Modifier.background(Color.Cyan))
            Text(text = "Madrid")
        }
        Column(Modifier.background(Color.Yellow)
            .fillMaxWidth(1f)){
            Text(text = "OLOLO")
            Text(text = "QAZ", Modifier.background(Color.Gray))
            Text(text = "Madrid")
        }
    }

}