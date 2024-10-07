package com.example.weatherapp.uxui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.weatherapp.model.WeatherResponse

@Composable
fun WeatherCard(weather: WeatherResponse) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text("City: ${weather.name}", fontSize = 20.sp)
            Text("Temperature: ${weather.main.temp} °C", fontSize = 20.sp)
            Text("Humidity: ${weather.main.humidity}%", fontSize = 20.sp)
//            Image(
//                painter = rememberAsyncImagePainter("http://openweathermap.org/img/wn/${weather.weather[0].icon}.png"),
//                contentDescription = null,
//                modifier = Modifier.size(50.dp)
//            )
        }
    }
}
