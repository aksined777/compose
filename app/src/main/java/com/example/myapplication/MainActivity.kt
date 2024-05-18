package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Gray)
            ) {

                itemsIndexed(
                    listOf(
                        DataItem(
                            R.drawable.islands,
                            "OLOLO",
                            "qweqweqwr ewrewr werwerwerwer dasfa sfsdfa sfsadf fsdfsdaa 12345 12345 12345 12345" +
                                    "qweqweqwr ewrewr werwerwerwer dasfa sfsdfa sfsadf fsdfsdaa 12345 12345 12345 12345" +
                                    "qweqweqwr ewrewr werwerwerwer dasfa sfsdfa sfsadf fsdfsdaa 12345 12345 12345 12345" +
                                    "qweqweqwr ewrewr werwerwerwer dasfa sfsdfa sfsadf fsdfsdaa 12345 12345 12345 12345"
                        ),
                        DataItem(
                            R.drawable.islands,
                            "qaz",
                            "qweqweqwr ewrewr werwerwerwer dasfa sfsdfa sfsadf fsdfsdaa"
                        ),
                        DataItem(
                            R.drawable.islands,
                            "OPOPO",
                            "qweqweqwr ewrewr werwerwerwer dasfa sfsdfa sfsadf fsdfsdaa"
                        ),
                        DataItem(
                            R.drawable.islands,
                            "Image",
                            "qweqweqwr ewrewr werwerwerwer dasfa sfsdfa sfsadf fsdfsdaa"
                        ),
                        DataItem(
                            R.drawable.islands,
                            "Zlo",
                            "qweqweqwr ewrewr werwerwerwer dasfa sfsdfa sfsadf fsdfsdaa"
                        ),
                        DataItem(
                            R.drawable.islands,
                            "1111",
                            "qweqweqwr ewrewr werwerwerwer dasfa sfsdfa sfsadf fsdfsdaa"
                        ),
                        DataItem(
                            R.drawable.islands,
                            "2222",
                            "qweqweqwr ewrewr werwerwerwer dasfa sfsdfa sfsadf fsdfsdaa"
                        ),
                        DataItem(
                            R.drawable.islands,
                            "3333",
                            "qweqweqwr ewrewr werwerwerwer dasfa sfsdfa sfsadf fsdfsdaa"
                        ),
                        DataItem(
                            R.drawable.islands,
                            "4444",
                            "qweqweqwr ewrewr werwerwerwer dasfa sfsdfa sfsadf fsdfsdaa"
                        ),
                        DataItem(
                            R.drawable.islands,
                            "5555",
                            "qweqweqwr ewrewr werwerwerwer dasfa sfsdfa sfsadf fsdfsdaa"
                        ),
                    )
                ) { index, item ->
                    ViewItem(item = item)
                }
            }
        }
    }
}

