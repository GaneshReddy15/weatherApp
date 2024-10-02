package com.example.weatherapp.repository

import com.example.weatherapp.model.WeatherResponse
import com.example.weatherapp.service.WeatherApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepository @Inject constructor(
    private val weatherApi: WeatherApi
) {
    suspend fun getWeatherByCity(cityName: String, apiKey: String): WeatherResponse {
        return weatherApi.getWeather(cityName, apiKey)
    }
}
