package com.example.weatherglance.data.network

import com.example.weatherglance.data.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("v1/forecast")
    suspend fun getCurrentWeather(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("current") current: String = "temperature_2m,relative_humidity_2m,apparent_temperature,precipitation,weather_code,wind_speed_10m",
        @Query("temperature_unit") temperatureUnit: String,
        @Query("wind_speed_unit") windSpeedUnit: String,
        @Query("timezone") timezone: String = "auto"
    ): WeatherResponse
}
