package com.example.weatherglance.data.model

import com.squareup.moshi.Json

data class WeatherResponse(
    @Json(name = "current") val current: CurrentWeather
)

data class CurrentWeather(
    @Json(name = "time") val time: String,
    @Json(name = "temperature_2m") val temperature: Double,
    @Json(name = "relative_humidity_2m") val relativeHumidity: Int,
    @Json(name = "apparent_temperature") val apparentTemperature: Double,
    @Json(name = "precipitation") val precipitation: Double,
    @Json(name = "weather_code") val weatherCode: Int,
    @Json(name = "wind_speed_10m") val windSpeed: Double
)
