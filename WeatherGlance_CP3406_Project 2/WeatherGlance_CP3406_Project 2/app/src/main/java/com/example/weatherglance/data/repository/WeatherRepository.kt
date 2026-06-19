package com.example.weatherglance.data.repository

import com.example.weatherglance.domain.City
import com.example.weatherglance.domain.TemperatureUnit
import com.example.weatherglance.domain.WeatherSnapshot

interface WeatherRepository {
    suspend fun fetchCurrentWeather(city: City, unit: TemperatureUnit): WeatherSnapshot
}
