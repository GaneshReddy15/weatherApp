package com.example.weatherapp.uxui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weatherapp.viewmodel.WeatherViewModel

@Composable
fun WeatherScreen(viewModel: WeatherViewModel = viewModel()) {
    var city by remember { mutableStateOf("") }
    val weatherState by viewModel.weatherData.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = city,
            onValueChange = { city = it },
            label = { Text("Enter City") }
        )

        Button(onClick = { viewModel.fetchWeather(city, "YOUR_API_KEY_HERE") }) {
            Text("Get Weather")
        }

        weatherState?.let { weather ->
            Text("City: ${weather.name}", fontSize = 20.sp)
            Text("Temperature: ${weather.main.temp} °C", fontSize = 20.sp)
            Text("Humidity: ${weather.main.humidity}%", fontSize = 20.sp)
            Image(
                painter = rememberImagePainter("http://openweathermap.org/img/wn/${weather.weather[0].icon}.png"),
                contentDescription = null
            )
        }
    }
}
