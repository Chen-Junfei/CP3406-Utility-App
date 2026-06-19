package com.example.weatherglance.data.repository

import com.example.weatherglance.data.network.WeatherApi
import com.example.weatherglance.domain.City
import com.example.weatherglance.domain.TemperatureUnit
import com.example.weatherglance.domain.WeatherSnapshot
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApi
) : WeatherRepository {
    override suspend fun fetchCurrentWeather(city: City, unit: TemperatureUnit): WeatherSnapshot {
        val response = weatherApi.getCurrentWeather(
            latitude = city.latitude,
            longitude = city.longitude,
            temperatureUnit = unit.apiValue,
            windSpeedUnit = unit.windApiValue
        )

        return WeatherSnapshot(
            city = city,
            temperature = response.current.temperature,
            apparentTemperature = response.current.apparentTemperature,
            humidity = response.current.relativeHumidity,
            precipitation = response.current.precipitation,
            windSpeed = response.current.windSpeed,
            weatherCode = response.current.weatherCode,
            updatedTime = response.current.time,
            unit = unit
        )
    }
}
