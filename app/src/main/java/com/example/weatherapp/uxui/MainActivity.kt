package com.example.weatherapp.uxui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.ComponentActivity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.example.weatherapp.uxui.WeatherScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppScreen()
        }
    }
}

@Composable
fun WeatherAppScreen() {
    MaterialTheme {
        Surface {
            WeatherScreen() // Your WeatherScreen composable
        }
    }
}

