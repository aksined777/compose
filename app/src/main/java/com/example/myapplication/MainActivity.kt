package com.example.myapplication

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.myapplication.data.WeatherModel
import com.example.myapplication.screen.DialogSearch
import com.example.myapplication.screen.MainCard
import com.example.myapplication.screen.TabLayout
import org.json.JSONObject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val daysList = remember {
                mutableStateOf(listOf<WeatherModel>())
            }

            val dialogState = remember {
                mutableStateOf(false)
            }



            val currentDay = remember {
                mutableStateOf(
                    WeatherModel(
                        "",
                        "",
                        "0.0",
                        "",
                        "",
                        "0.0",
                        "0.0",
                        ""
                    )
                )
            }
            if(dialogState.value ){
                DialogSearch(dialogState, onSubmit = {
                    getData(it, this, daysList, currentDay)
                })
            }

            getData("Moscow", this, daysList, currentDay)

            Image(
                painter = painterResource(id = R.drawable.mks),
                contentDescription = "im1",
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(0.9f),
                contentScale = ContentScale.FillBounds
            )
            Column {
                MainCard(currentDay,
                    onClickSync = {
                        getData("Moscow", this@MainActivity, daysList, currentDay)
                    },
                    onClickSearch = {
                        dialogState.value = true
                    })
                TabLayout(daysList, currentDay)
            }
        }
    }
}


private fun getData(
    name: String,
    context: Context,
    state: MutableState<List<WeatherModel>>,
    currentDay: MutableState<WeatherModel>
) {
    val API_KEY = "aa05fd44130742cf8b3181636241905"
    val url = "https://api.weatherapi.com/v1/forecast.json" +
            "?key=$API_KEY&" +
            "&q=$name" +
            "&days=3" +
            "&aqi=no&alerts=yes"
    val queue = Volley.newRequestQueue(context)
    val stringRequest = StringRequest(
        Request.Method.GET,
        url,
        { responce ->
            val list = getWeatherByDay(responce)
            currentDay.value = list[0]
            state.value = list
        },
        {
            val ololo = it
        })
    queue.add(stringRequest)
}

private fun getWeatherByDay(responce: String): List<WeatherModel> {
    if (responce.isEmpty()) return listOf()
    val mainObject = JSONObject(responce)
    val list = ArrayList<WeatherModel>()
    val city = mainObject.getJSONObject("location").getString("name")
    val days = mainObject.getJSONObject("forecast").getJSONArray("forecastday")
    for (i in 0 until days.length()) {
        val item = days[i] as JSONObject
        list.add(
            WeatherModel(
                city = city,
                time = item.getString("date"),
                currentTemp = "",
                condition = item.getJSONObject("day").getJSONObject("condition").getString("text"),
                icon = item.getJSONObject("day").getJSONObject("condition").getString("icon"),
                minTemp = item.getJSONObject("day").getString("mintemp_c"),
                maxTemp = item.getJSONObject("day").getString("maxtemp_c"),
                hours = item.getJSONArray("hour").toString()
            )
        )

        // скопировать обьект но заменить там 2 поля
        list[0] = list[0].copy(
            time = mainObject.getJSONObject("current").getString("last_updated"),
            currentTemp = mainObject.getJSONObject("current").getString("temp_c"),
        )

    }
    return list
}