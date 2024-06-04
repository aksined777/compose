package com.example.myapplication.button_navigation

import com.example.myapplication.R

sealed class BottonItem(val title: String, val iconId: Int, val route: String) {
    object Screen1 : BottonItem("Title 1", R.drawable.baseline_cancel_presentation_24, "screen_name_1")
    object Screen2 : BottonItem("Title 2", R.drawable.baseline_cancel_presentation_24, "screen_name_2")
    object Screen3 : BottonItem("333", R.drawable.baseline_cancel_presentation_24, "screen_3")
    object Screen4 : BottonItem("444", R.drawable.baseline_cancel_presentation_24, "screen_name_4")

}